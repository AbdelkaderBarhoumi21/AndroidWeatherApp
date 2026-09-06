package com.example.androidweatherapp.di

import android.app.Application
import com.example.androidweatherapp.BuildConfig
import com.example.androidweatherapp.data.remote.WeatherApi
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    // Okhttp client
    @Provides
    @Singleton
    fun okhttp(): OkHttpClient{
        val logging = HttpLoggingInterceptor().apply {
            level = if(BuildConfig.DEBUG){
                HttpLoggingInterceptor.Level.BODY
            }else{
                HttpLoggingInterceptor.Level.NONE

            }
        }
        return OkHttpClient.Builder().addInterceptor(logging).connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L,
            TimeUnit.SECONDS).build()
    }

    // Retrofit
    @Provides
    @Singleton
    fun retrofit(client: OkHttpClient): Retrofit =
         ApiClientFactory.retrofit(BuildConfig.BASE_URL, client)

    // Weather Api
    @Provides
    @Singleton
    fun providesWeatherApi(retrofit: Retrofit): WeatherApi = retrofit.create(WeatherApi::class.java)

    // Location
    @Provides
    @Singleton
    fun providesFusedLocationProviderClient(app: Application): FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(app)

}