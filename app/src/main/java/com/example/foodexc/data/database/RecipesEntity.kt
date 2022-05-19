package com.example.foodexc.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.foodexc.models.FoodRecipe
import com.example.foodexc.util.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(
    var foodRecipe: FoodRecipe
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}