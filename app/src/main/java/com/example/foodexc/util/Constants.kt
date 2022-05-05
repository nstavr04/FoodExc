package com.example.foodexc.util

class Constants {

    // something like static in java
    companion object {

        const val BASE_URL = "https://api.spoonacular.com"
        const val API_KEY = "8f7db6b0bb5c426f8b3e4b2ec09072ec"

        // API Query Keys
        const val QUERY_NUMBER = "number"
        const val QUERY_API_KEY = "apiKey"
        const val QUERY_TYPE = "type"
        const val QUERY_CHEAP = "cuisine"
        const val QUERY_ADD_RECIPE_INFORMATION = "addRecipeInformation"
        const val QUERY_FILL_INGREDIENTS = "fillIngredients"

        // ROOM Database
        const val DATABASE_NAME = "recipes_database"
        const val RECIPES_TABLE = "recipes_table"

    }

}