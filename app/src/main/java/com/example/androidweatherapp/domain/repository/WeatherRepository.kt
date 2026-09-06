package com.example.androidweatherapp.domain.repository

import com.example.androidweatherapp.domain.util.AppResult
import com.example.androidweatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat:Double,long:Double): AppResult<WeatherInfo>
}