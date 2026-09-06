package com.example.androidweatherapp.presentation.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.androidweatherapp.core.constants.AppSizes
import com.example.androidweatherapp.core.constants.AppStrings
import com.example.androidweatherapp.presentation.viewmodel.WeatherState

@Composable
fun WeatherForecast(
    state: WeatherState,
    modifier: Modifier= Modifier
){
    state.weatherInfo?.weatherDataPerDay?.get(0)?.let {
        data ->
        Column(
            modifier = modifier.fillMaxWidth().padding(horizontal = AppSizes.paddingNormal),
        ) {
            Text(
                text = AppStrings.TODAY,
                fontSize = AppSizes.textNormal,
                color = Color.White,
            )
            Spacer(modifier= Modifier.height(AppSizes.paddingNormal))
            LazyRow(
                content = {
                    items(data.size) { index ->
                        HourlyWeatherDisplay(
                            weatherData = data[index],
                            modifier = Modifier.height(AppSizes.cardHeight).padding(horizontal = AppSizes.paddingNormal)
                        )
                    }
                }
            )
        }
    }
}
