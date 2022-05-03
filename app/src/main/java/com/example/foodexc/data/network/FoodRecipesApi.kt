package com.example.foodexc.data.network

import com.example.foodexc.models.FoodRecipe
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface FoodRecipesApi {

    // Returns a food recipe object response
    // Runs on a background thread
    @GET(value = "/recipes/complexSearch")
    suspend fun getRecipes(
        @QueryMap queries: Map<String, String>
    ): Response<FoodRecipe>

}