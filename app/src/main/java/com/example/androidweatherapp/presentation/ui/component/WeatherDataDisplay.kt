package com.example.androidweatherapp.presentation.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import com.example.androidweatherapp.core.constants.AppSizes

@Composable
fun WeatherDataDisplay(
    value:Int,
    unit:String,
    icon: ImageVector,
    modifier : Modifier= Modifier,
    textStyle: TextStyle= TextStyle(),
    iconTint: Color=Color.White
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconTint,
            modifier = Modifier.size(AppSizes.iconSmall)
        )
        Spacer(modifier = Modifier.width(AppSizes.paddingSmall))
        Text(
            text = "$value $unit",
            style = textStyle
        )
    }
}
