package com.example.foodexc.viewmodels

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.foodexc.data.Repository
import com.example.foodexc.data.database.RecipesEntity
import com.example.foodexc.models.FoodRecipe
import com.example.foodexc.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

// https://developer.android.com/training/dependency-injection/hilt-cheatsheet

// ViewModelInject: Tells Hilt how to provide instances of an Architecture Component ViewModel

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    application: Application
    ) : AndroidViewModel(application) {

    /** ROOM DATABASE */

    val readRecipes: LiveData<List<RecipesEntity>> = repository.local.readDatabase().asLiveData()

    private fun insertRecipes(recipesEntity: RecipesEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.insertRecipes(recipesEntity)
        }


    /** RETROFIT */
    var recipesResponse: MutableLiveData<NetworkResult<FoodRecipe>> = MutableLiveData()

    fun getRecipes(queries: Map<String, String>) = viewModelScope.launch {
        getRecipesSafeCall(queries)
    }


    private suspend fun getRecipesSafeCall(queries: Map<String, String>){
        // We first response with a loading state until we get our response
        recipesResponse.value = NetworkResult.Loading()
        if(hasInternetConnection()){
            try{
                val response = repository.remote.getRecipes(queries)
                recipesResponse.value = handleFoodRecipesResponse(response)

                // We also cache data as soon as we receive it
                val foodRecipe = recipesResponse.value!!.data
                if(foodRecipe != null){
                    offlineCacheRecipes(foodRecipe)
                }

            }catch (e: Exception){
                recipesResponse.value = NetworkResult.Error("Recipes not found.")
            }
        }
        else{
            recipesResponse.value = NetworkResult.Error("Oops, looks like there's no \n internet connection!")
        }
    }

    private fun offlineCacheRecipes(foodRecipe: FoodRecipe){
        val recipesEntity = RecipesEntity(foodRecipe)
        insertRecipes(recipesEntity)
    }

    private fun handleFoodRecipesResponse(response: Response<FoodRecipe>): NetworkResult<FoodRecipe>? {
        when {
            response.message().toString().contains("timeout") -> {
                return NetworkResult.Error("Timeout")
            }
            response.code() == 402 -> {
                return NetworkResult.Error("API Key Limited.")
            }
            // !! returns null exception is the value is null
            response.body()!!.results.isNullOrEmpty() -> {
                return NetworkResult.Error("Recipes not found.")
            }
            response.isSuccessful -> {
                val foodRecipes = response.body()
                return NetworkResult.Success(foodRecipes!!)
            }
            else -> {
                return NetworkResult.Error(response.message())
            }
        }
    }

    private fun hasInternetConnection(): Boolean{

        val connectivityManager = getApplication<Application>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager

        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }

    }

    }