package com.example.foodexc.util

import androidx.recyclerview.widget.DiffUtil

class RecipesDiffUtil<T>(
    private val oldList: List<T>,
    private val newList: List<T>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        // === Something like compareTo
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    // Check if the two items have the new data. Only called when areItemsTheSame returns True
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }
}