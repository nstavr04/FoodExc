package com.example.foodexc.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LiveData<T>.observeOnce(lifeCycleOwner: LifecycleOwner, observer: Observer<T>) {
    observe(lifeCycleOwner, object: Observer<T>{
        override fun onChanged(t : T?){
            removeObserver(this)
            observer.onChanged(t)
        }
    })
}