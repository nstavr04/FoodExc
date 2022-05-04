package com.example.foodexc.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.foodexc.util.Constants
import com.example.foodexc.util.Constants.Companion.QUERY_ADD_RECIPE_INFORMATION
import com.example.foodexc.util.Constants.Companion.QUERY_API_KEY
import com.example.foodexc.util.Constants.Companion.QUERY_CHEAP
import com.example.foodexc.util.Constants.Companion.QUERY_FILL_INGREDIENTS
import com.example.foodexc.util.Constants.Companion.QUERY_NUMBER
import com.example.foodexc.util.Constants.Companion.QUERY_TYPE

class RecipesViewModel(application: Application): AndroidViewModel(application) {

    fun applyQueries(): HashMap<String, String>{
        val queries: HashMap<String, String> = HashMap()

        queries[QUERY_NUMBER] = "6"
        queries[QUERY_API_KEY] = Constants.API_KEY
        queries[QUERY_TYPE] = "snack"
        queries[QUERY_CHEAP] = "true"
        queries[QUERY_ADD_RECIPE_INFORMATION] = "true"
        queries[QUERY_FILL_INGREDIENTS] = "true"

        return queries
    }

}