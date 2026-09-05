package com.example.androidweatherapp.domain.weather

data class WeatherInfo(
    // Int  Key => current day index
    val weatherDataPerDay:Map<Int,List<WeatherData>>,
    val currentWeatherData:WeatherData?,
)