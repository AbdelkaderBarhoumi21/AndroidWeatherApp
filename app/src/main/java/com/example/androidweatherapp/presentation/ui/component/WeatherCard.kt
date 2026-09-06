package com.example.androidweatherapp.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import com.example.androidweatherapp.R
import com.example.androidweatherapp.core.constants.AppSizes
import com.example.androidweatherapp.core.constants.AppStrings
import com.example.androidweatherapp.presentation.viewmodel.WeatherState
import java.time.format.DateTimeFormatter

@Composable
fun WeatherCard(
    state: WeatherState,
    backgroundColor: Color,
    modifier:Modifier= Modifier

){
    state.weatherInfo?.currentWeatherData?.let { data ->
        Card(
        colors = CardDefaults.cardColors(
            backgroundColor
        ),
        shape = RoundedCornerShape(AppSizes.paddingMedium),
        modifier = modifier.padding(AppSizes.paddingNormal)

    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(AppSizes.paddingNormal),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier=Modifier.align(Alignment.End),
                text="${AppStrings.TODAY} ${data.time.format(DateTimeFormatter.ofPattern(AppStrings.TIME_FORMAT))}",
                color = Color.White,
            )
            Spacer(modifier = Modifier.height(AppSizes.paddingNormal))
            Image(
                painter = painterResource(id=data.weatherType.iconRes),
                contentDescription = null,
                modifier = Modifier.width(AppSizes.imageLarge)
            )
            Spacer(modifier = Modifier.height(AppSizes.paddingNormal))
            Text(
                text= "${data.temperatureCelsius}${AppStrings.CELSIUS}",
                fontSize = AppSizes.textLarge,
                color = Color.White,
            )
            Spacer(modifier = Modifier.height(AppSizes.paddingNormal))
            Text(
                text=data.weatherType.weatherDesc,
                fontSize = AppSizes.textNormal,
                color = Color.White.copy(alpha = 0.7F)
            )

            Spacer(modifier = Modifier.height(AppSizes.paddingLarge))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                WeatherDataDisplay(
                    value=data.pressure.toInt(),
                    unit = AppStrings.PRESSURE_UNIT,
                    icon = ImageVector.vectorResource(id=R.drawable.ic_pressure),
                    iconTint = Color.White,
                    textStyle = TextStyle(color = Color.White)
                )
                WeatherDataDisplay(
                    value=data.humidity,
                    unit = AppStrings.HUMIDITY_UNIT,
                    icon = ImageVector.vectorResource(id=R.drawable.ic_drop),
                    iconTint = Color.White,
                    textStyle = TextStyle(color = Color.White)
                )
                WeatherDataDisplay(
                    value=data.windSpeed.toInt(),
                    unit = AppStrings.WIND_SPEED_UNIT,
                    icon = ImageVector.vectorResource(id=R.drawable.ic_wind),
                    iconTint = Color.White,
                    textStyle = TextStyle(color = Color.White)
                )
            }
        }
    }

    }
}
