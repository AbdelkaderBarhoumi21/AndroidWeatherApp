package com.example.androidweatherapp.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.androidweatherapp.core.constants.AppSizes
import com.example.androidweatherapp.core.constants.AppStrings
import com.example.androidweatherapp.domain.weather.WeatherData
import java.time.format.DateTimeFormatter

@Composable
fun HourlyWeatherDisplay(
    weatherData: WeatherData,
    modifier: Modifier= Modifier,
    textColor: Color= Color.White
){

    val formattedTime= remember(weatherData) {
        weatherData.time.format(DateTimeFormatter.ofPattern(AppStrings.TIME_FORMAT))
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        Text(
            text =formattedTime,
            color = Color.LightGray
        )
        Image(
            painter = painterResource(id = weatherData.weatherType.iconRes),
            contentDescription = null,
            modifier=Modifier.width(AppSizes.iconMedium)
        )
        Text(
            text="${weatherData.temperatureCelsius}${AppStrings.CELSIUS}",
            color = textColor,
            fontWeight = FontWeight.Bold
        )
    }
}
