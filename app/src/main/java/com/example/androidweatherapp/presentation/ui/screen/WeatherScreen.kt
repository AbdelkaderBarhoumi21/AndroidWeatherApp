package com.example.androidweatherapp.presentation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.example.androidweatherapp.core.constants.AppSizes
import com.example.androidweatherapp.presentation.ui.component.WeatherCard
import com.example.androidweatherapp.presentation.ui.component.WeatherForecast
import com.example.androidweatherapp.presentation.viewmodel.WeatherState
import com.example.androidweatherapp.theme.DarkBlue
import com.example.androidweatherapp.theme.DeepBlue

@Composable
fun WeatherScreen(
    state: WeatherState
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {
            WeatherCard(
                state = state,
                backgroundColor = DeepBlue
            )
            Spacer(modifier = Modifier.height(AppSizes.paddingNormal))
            WeatherForecast(state = state)
        }
        
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Color.White
            )
        }
        
        state.error?.let { error ->
            Text(
                text = error,
                color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(AppSizes.paddingNormal)
            )
        }
    }
}
