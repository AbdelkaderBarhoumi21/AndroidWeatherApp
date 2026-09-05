package com.example.androidweatherapp.domain.weather

data class WeatherInfo(
    // Int  Key => current day index
    // for example for today 1 it will have Map<1,List<WeatherData>>  List of 24 WeatherData : each item has 1  hour of WeatherData (1 day= 24 hour)
    val weatherDataPerDay:Map<Int,List<WeatherData>>,
    val currentWeatherData:WeatherData?,
)