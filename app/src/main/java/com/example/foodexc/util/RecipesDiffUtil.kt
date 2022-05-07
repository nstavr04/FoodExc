package com.example.foodexc.util

import androidx.recyclerview.widget.DiffUtil
import com.example.foodexc.models.Result

// Maybe in future we can use AsyncListDiffer so it would run in the background

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
        // === something like compareTo
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    // check if the two items have the new data. Only called when areItemsTheSame returns True
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }
}