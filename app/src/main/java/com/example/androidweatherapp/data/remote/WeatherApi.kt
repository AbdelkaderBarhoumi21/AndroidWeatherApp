package com.example.androidweatherapp.data.remote

import com.example.androidweatherapp.core.constants.AppConstants
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi{
    @GET(AppConstants.WEATHER_ENDPOINT)
    suspend fun getWeatherData(
        @Query("latitude") lat:Double,
        @Query("longitude") long:Double,
    ): WeatherDto
}
