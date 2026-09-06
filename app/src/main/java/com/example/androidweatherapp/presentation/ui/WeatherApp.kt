package com.example.androidweatherapp.presentation.ui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


/**
 * The main [android.app.Application] class for the Android Weather App.
 *
 * This class is annotated with [HiltAndroidApp], which triggers Hilt's code generation,
 * including a base class for the application that serves as the application-level
 * dependency container.
 */
@HiltAndroidApp
class WeatherApp : Application() {
}