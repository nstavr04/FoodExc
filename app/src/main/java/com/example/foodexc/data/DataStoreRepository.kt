package com.example.foodexc.data

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import com.example.foodexc.util.Constants.Companion.DEFAULT_CUISINE_TYPE
import com.example.foodexc.util.Constants.Companion.DEFAULT_MEAL_TYPE
import com.example.foodexc.util.Constants.Companion.PREFERENCES_NAME
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

@ActivityRetainedScoped
class DataStoreRepository @Inject constructor(@ApplicationContext private val context: Context){

    private object PreferenceKeys {
        val selectedMealType = preferencesKey<String>("mealType")
        val selectedMealTypeId = preferencesKey<Int>("mealTypeId")
        val selectedCuisineType = preferencesKey<String>("cuisineType")
        val selectedCuisineTypeId = preferencesKey<Int>("cuisineTypeId")
    }

    private val dataStore: DataStore<Preferences> = context.createDataStore(name = PREFERENCES_NAME)

    suspend fun saveMealAndCuisineType(mealType: String, mealTypeId: Int, cuisineType: String, cuisineTypeId: Int){
        dataStore.edit { preferences ->
            preferences[PreferenceKeys.selectedMealType] = mealType
            preferences[PreferenceKeys.selectedMealTypeId] = mealTypeId
            preferences[PreferenceKeys.selectedCuisineType] = cuisineType
            preferences[PreferenceKeys.selectedCuisineTypeId] = cuisineTypeId
        }
    }

    val readMealAndCuisineType: Flow<MealAndCuisineType> = dataStore.data
        .catch { exception ->
            if(exception is IOException){
                emit(emptyPreferences())
            } else{
                throw exception
            }
        }
            // if there is any value on the specific key we will return the string on the right (elvis operator)
        .map { preferences ->
            val selectedMealType = preferences[PreferenceKeys.selectedMealType] ?: DEFAULT_MEAL_TYPE
            val selectedMealTypeId = preferences[PreferenceKeys.selectedMealTypeId] ?: 0
            val selectedCuisineType = preferences[PreferenceKeys.selectedCuisineType] ?: DEFAULT_CUISINE_TYPE
            val selectedCuisineTypeId = preferences[PreferenceKeys.selectedCuisineTypeId] ?: 0
            MealAndCuisineType(
                selectedMealType,
                selectedMealTypeId,
                selectedCuisineType,
                selectedCuisineTypeId
            )
        }

}

data class MealAndCuisineType(
    val selectedMealType: String,
    val selectedMealTypeId: Int,
    val selectedCuisineType: String,
    val selectedCuisineTypeId: Int
)