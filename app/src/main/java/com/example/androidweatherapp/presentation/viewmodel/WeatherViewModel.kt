package com.example.androidweatherapp.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidweatherapp.core.constants.AppStrings
import com.example.androidweatherapp.domain.location.LocationTracker
import com.example.androidweatherapp.domain.repository.WeatherRepository
import com.example.androidweatherapp.domain.util.AppResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val locationTracker: LocationTracker,
) : ViewModel (){
    
    var state by mutableStateOf(WeatherState())
        private set

    fun loadWeatherInfo(){
        viewModelScope.launch {
            state=state.copy(
                isLoading = true,
                error = null
            )
            locationTracker.getCurrentLocation()?.let { location ->
                when (val result = weatherRepository.getWeatherData(location.latitude,location.longitude)){
                     is AppResult.Success -> {
                       state=  state.copy(
                             weatherInfo = result.data,
                             isLoading = false,
                             error = null
                         )
                     }
                    is AppResult.Error -> {
                      state=  state.copy(
                            weatherInfo = null,
                            isLoading = false,
                            error = result.message,
                        )
                    }
                }
            } ?: kotlin.run {
                state= state.copy(
                    isLoading = false,
                    error = AppStrings.ERROR_LOCATION
                )
            }
        }
    }
}
