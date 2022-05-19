package com.example.foodexc.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LiveData<T>.observeOnce(lifeCycleOwner: LifecycleOwner, observer: Observer<T>) {
    observe(lifeCycleOwner, object : Observer<T> {
        // had to reverse lines 11 and 12 and also remove T? from line 10
        override fun onChanged(t: T) {
            observer.onChanged(t)
            removeObserver(this)
        }
    })
}