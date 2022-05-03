package com.example.foodexc.data

import com.example.foodexc.data.network.FoodRecipesApi
import com.example.foodexc.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

// Request data from our api
// https://developer.android.com/training/dependency-injection
class RemoteDataSource @Inject constructor(
    private val foodRecipesApi: FoodRecipesApi
) {

    suspend fun getRecipes(queries: Map<String, String>): Response<FoodRecipe>{
        return foodRecipesApi.getRecipes(queries)
    }

}