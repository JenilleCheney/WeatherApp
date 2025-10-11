package com.example.weatherapp

import androidx.lifecycle.ViewModel
import com.example.weatherapp.models.Current
import com.example.weatherapp.models.Forecast
import com.example.weatherapp.models.Weather
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


open class MainViewModel : ViewModel() {
    private val _weather = MutableStateFlow<Weather?>(null)
    val weather = _weather.asStateFlow()

    init {
        //create weather placeholder
        val weather = Weather(
            current = Current(
                imageId = R.drawable.sun_showers,
                condition = "Sun Showers",
                temperature = "10°C",
                precipitationType = "Rain",
                precipitationAmount = "3mm",
                wind = "Wind SW 10kph"
            ),
            forecast = listOf(

            // Thursday
            Forecast(
                date = "Thursday October 9th",
                imageId = R.drawable.sunny_day,
                temperatureHigh = "High: 25°C",
                temperatureLow = "Low: 10°C",
                condition = "Sunny",
                precipitationType = "None",
                precipitationAmount = "0mm",
                precipitationProbability = "0%",
                wind = "Maximum winds 10kph.",
                humidity = "Humidity 85%"
            ),
            // Friday
            Forecast(
                date = "Friday October 10th",
                imageId = R.drawable.cloudy_day,
                temperatureHigh = "High: 15°C",
                temperatureLow = "Low: 4°C",
                condition = "Overcast",
                precipitationType = "None",
                precipitationAmount = "0mm",
                precipitationProbability = "10%",
                wind = "Maximum winds 20kph",
                humidity = "Humidity 65%"
            ),
            // Saturday
            Forecast(
                date = "Saturday October 11th",
                imageId = R.drawable.rainy_day,
                temperatureHigh = "High: 6°C",
                temperatureLow = "Low: 2°C",
                condition = "Torrential Rain",
                precipitationType = "Rain",
                precipitationAmount = "25mm",
                precipitationProbability = "95%",
                wind = "Maximum winds 30kph",
                humidity = "Humidity 60%"
            )
        )
        )

        _weather.value = weather
    }
}

