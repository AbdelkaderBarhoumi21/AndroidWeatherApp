package com.example.androidweatherapp.di

import com.example.androidweatherapp.data.location.DefaultLocationTracker
import com.example.androidweatherapp.data.repository.WeatherRepositoryImpl
import com.example.androidweatherapp.domain.location.LocationTracker
import com.example.androidweatherapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

abstract class RepositoryModule{
    @Binds
    @Singleton
    abstract fun  bindsWeatherRepository (weatherRepositoryImpl: WeatherRepositoryImpl) : WeatherRepository
}