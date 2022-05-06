package com.example.foodexc.viewmodels

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodexc.data.DataStoreRepository
import com.example.foodexc.util.Constants.Companion.DEFAULT_CUISINE_TYPE
import com.example.foodexc.util.Constants.Companion.DEFAULT_MEAL_TYPE
import com.example.foodexc.util.Constants.Companion.DEFAULT_RECIPES_NUMBER
import com.example.foodexc.util.Constants.Companion.QUERY_ADD_RECIPE_INFORMATION
import com.example.foodexc.util.Constants.Companion.QUERY_API_KEY
import com.example.foodexc.util.Constants.Companion.QUERY_CHEAP
import com.example.foodexc.util.Constants.Companion.QUERY_FILL_INGREDIENTS
import com.example.foodexc.util.Constants.Companion.QUERY_NUMBER
import com.example.foodexc.util.Constants.Companion.QUERY_TYPE
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RecipesViewModel @ViewModelInject constructor(
    application: Application,
    private val dataStoreRepository: DataStoreRepository
) : AndroidViewModel(application) {

    private var mealType = DEFAULT_MEAL_TYPE
    private var cuisineType = DEFAULT_CUISINE_TYPE

    val readMealAndCuisineType = dataStoreRepository.readMealAndCuisineType

    fun saveMealAndCuisineType(
        mealType: String,
        mealTypeId: Int,
        cuisineType: String,
        cuisineTypeId: Int
    ) = viewModelScope.launch(IO){
        dataStoreRepository.saveMealAndCuisineType(mealType, mealTypeId,cuisineType,cuisineTypeId)
    }

    fun applyQueries(): HashMap<String, String> {
        val queries: HashMap<String, String> = HashMap()

        viewModelScope.launch {
            readMealAndCuisineType.collect { value ->
                mealType = value.selectedMealType
                cuisineType = value.selectedCuisineType
            }
        }

        // If we use the API_KEY constants we have error with the API sometimes. Not sure tho
        queries[QUERY_NUMBER] = DEFAULT_RECIPES_NUMBER
        queries[QUERY_API_KEY] = "8f7db6b0bb5c426f8b3e4b2ec09072ec"
        queries[QUERY_TYPE] = mealType
        queries[QUERY_CHEAP] = cuisineType
        queries[QUERY_ADD_RECIPE_INFORMATION] = "true"
        queries[QUERY_FILL_INGREDIENTS] = "true"

        return queries
    }

}