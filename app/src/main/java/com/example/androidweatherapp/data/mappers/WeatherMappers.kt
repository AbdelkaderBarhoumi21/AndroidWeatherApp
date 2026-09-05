package com.example.androidweatherapp.data.mappers

import com.example.androidweatherapp.data.remote.WeatherDataDto
import com.example.androidweatherapp.data.remote.WeatherDto
import com.example.androidweatherapp.domain.weather.WeatherData
import com.example.androidweatherapp.domain.weather.WeatherInfo
import com.example.androidweatherapp.domain.weather.WeatherType
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


/*
index 0  / 24 = 0
index 1  / 24 = 0
...
index 23 / 24 = 0
index 24 / 24 = 1   ← Pass to the next day
index 25 / 24 = 1

  => result after groupBy
      Map<Int, List<IndexedWeatherData>>
        {
    0: [IndexedWeatherData(0, ...), IndexedWeatherData(1, ...), ..., IndexedWeatherData(23, ...)],
    1: [IndexedWeatherData(24, ...), IndexedWeatherData(25, ...), ...]
        }
  => result after mapValues
       Map<Int, List<WeatherData>>
        {
    0: [WeatherData(...), WeatherData(...), ...],   // jour 0, 24 heures
    1: [WeatherData(...), WeatherData(...), ...]    // jour 1, 24 heures
        }
 */
private data class IndexedWeatherData(
    val index:Int,
    val data:WeatherData,
)
fun WeatherDataDto.toWeatherDataMap():Map<Int,List<WeatherData>> {
      return time.mapIndexed { index, timeItem ->
          val temperature = temperatures[index]
          val humidity= humidities[index]
          val weatherCode= weatherCodes[index]
          val pressure= pressures[index]
          val windSpeed=windSpeeds[index]
          IndexedWeatherData(
              index = index,
              data = WeatherData(
                  time = LocalDateTime.parse(timeItem, DateTimeFormatter.ISO_DATE_TIME),
                  temperatureCelsius = temperature,
                  humidity = humidity,
                  weatherType = WeatherType.fromApi(weatherCode),
                  pressure = pressure,
                  windSpeed = windSpeed
              ),
          )
      }.groupBy {
          it.index /24
      }.mapValues {
          it.value.map { it.data }
      }
}

fun WeatherDto.toWeatherInfo(): WeatherInfo{
    val weatherDataMap=weatherData.toWeatherDataMap()
    val now= LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        // if we have 1:20PM  => 1PM  else 1:50PM => 2pm
       val hour=  if(now .minute < 30) now.hour else now.hour + 1
        it.time.hour== hour
    }
    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}