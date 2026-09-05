package com.example.androidweatherapp.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDataDto(
    val time:List<String>,
    @SerialName("temperature_2m")
    val temperature:List<Double>,
     @SerialName("weathercode")
    val weatherCode:List<Int>,
    @SerialName("relativehumidity_2m")
    val humidity:List<Int>,
    @SerialName("windspeed_10m")
    val windSpeed:List<Double>,
    @SerialName("pressure_msl")
    val pressure:List<Double>,
)