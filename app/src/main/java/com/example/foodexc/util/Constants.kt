package com.example.foodexc.util

class Constants {

    // something like static in java
    companion object {

        const val BASE_URL = "https://api.spoonacular.com"
        const val BASE_IMAGE_URL = "https://spoonacular.com/cdn/ingredients_100x100/"
        const val API_KEY = "8f7db6b0bb5c426f8b3e4b2ec09072ec"

        const val RECIPE_RESULT_KEY = "recipeBundle"

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

        // Bottom Sheet and Preferences
        const val DEFAULT_RECIPES_NUMBER = "2"
        const val DEFAULT_MEAL_TYPE = "main course"
        const val DEFAULT_CUISINE_TYPE = "greek"

        const val PREFERENCES_NAME = "foodexc_preferences"
        const val PREFERENCES_MEAL_TYPE = "mealType"
        const val PREFERENCES_MEAL_TYPE_ID = "mealTypeId"
        const val PREFERENCES_CUISINE_TYPE = "cuisineType"
        const val PREFERENCES_CUISINE_TYPE_ID = "cuisineTypeId"



    }

}