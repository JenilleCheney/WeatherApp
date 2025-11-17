
package com.example.weatherapp.models

import com.google.gson.annotations.SerializedName

data class Weather(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)

data class Location(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    val localTime: Int
)

data class Condition(
    val text: String,
    val icon: String
)

data class Current(
    @SerializedName("temp_c") val temperature: Float,
    @SerializedName("feelslike_c") val feelsLike: Float,
    @SerializedName("condition") val condition: Condition,
    @SerializedName("wind_kph") val windSpeed: Float,
    @SerializedName("wind_dir") val windDirection: String,
    @SerializedName("precip_mm") val precipitationAmount: Double
)

data class Forecast(
    @SerializedName("forecastday") val forecastDay: List<ForecastDay>
)

data class ForecastDay(
    @SerializedName("date") val date: String,
    @SerializedName("day") val day: Day,
    @SerializedName("hour") val hours: List<Hour>
)

data class Day(
    @SerializedName("maxtemp_c") val maxTemp: Float,
    @SerializedName("mintemp_c") val minTemp: Float,
    @SerializedName("maxwind_kph") val maxWind: Float,
    @SerializedName("totalprecip_mm") val precipitationAmount: Float,
    @SerializedName("daily_chance_of_rain") val chanceOfRain: Int,
    @SerializedName("avghumidity") val avgHumidity: Float,
    val condition: Condition
)

data class Hour(
    @SerializedName("time") val hour:String,
    @SerializedName("temp_c") val temperature: Float,
    @SerializedName("condition") val condition: Condition,
    @SerializedName("precip_mm") val precipitationAmount: Double
)
