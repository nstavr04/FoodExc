package com.example.foodexc

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// Extends application class

//Triggers hilt code generation
@HiltAndroidApp
class MyApplication : Application() {}