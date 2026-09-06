package com.example.androidweatherapp.data.repository

import com.example.androidweatherapp.data.mappers.toWeatherInfo
import com.example.androidweatherapp.data.remote.WeatherApi
import com.example.androidweatherapp.domain.repository.WeatherRepository
import com.example.androidweatherapp.domain.util.AppResult
import com.example.androidweatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository{
    override suspend fun getWeatherData(lat: Double, long: Double): AppResult<WeatherInfo> {
        return try {
            val result= api.getWeatherData(lat = lat, long = long)
            AppResult.Success(result.toWeatherInfo())

        }catch (e: Exception){
            e.printStackTrace()
            AppResult.Error(e.message ?: " An unknown error ocurred")
        }
    }
}