package com.example.androidweatherapp.core.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
@Composable
fun WeatherAppTheme(content: @Composable () -> Unit){
    MaterialTheme(
        typography = Typography,
        shapes = shapes,
        content = content
    )
}