// kotlin
package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.weatherapp.MainViewModel


@Composable
fun DailyForecast(mainViewModel: MainViewModel) {
    val weather by mainViewModel.weather.collectAsState()
    val forecastDays = weather?.forecast?.forecastDay
    if (!forecastDays.isNullOrEmpty()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,


        ) {
            items(forecastDays) { forecastDay ->
                // Use the actual variables provided by the lambda
                val day = forecastDay.day
                val date = forecastDay.date

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp), thickness = 1.dp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
                    )

                    // Show date and a simple representation of the day object.
                    Text(
                        text = date,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(top = 10.dp)
                    )

                    Image(
                        painter = rememberAsyncImagePainter("https:${day.condition.icon}"),
                        contentDescription = "Weather Icon",
                        modifier = Modifier
                            .size(100.dp)

                    )

                    Text(
                        text="${day.condition.text}.",
                        style = MaterialTheme.typography.bodyLarge,
                    )

                    Text(
                        text ="Max: ${day.maxTemp}°C / Min: ${day.minTemp}°C",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold
                    )

                    Text(
                        text = "Chance of Rain: ${day.chanceOfRain}% " +
                                "| Amount ${day.precipitationAmount}mm " ,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center

                    )

                    Text(
                        text = "Humidity: ${day.avgHumidity}%" ,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text=  "Maximum Wind: ${day.maxWind} kph" ,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}



//    Column(
//        //BACKGROUND
//        verticalArrangement = Arrangement.SpaceAround,
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//    )
//
//    {
//        HorizontalDivider(
//            thickness = 2.dp,
//            color = Color.Gray,
//            modifier = Modifier.padding(vertical = 8.dp)
//
//        )
//
//        Row(
//            horizontalArrangement = Arrangement.SpaceAround,
//            modifier = Modifier
//                .fillMaxWidth()
//        ) { Text("Wednesday October 8th") }
//
//        Row(horizontalArrangement = Arrangement.SpaceAround,
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//
//            Image(
//                painter = painterResource(id = R.drawable.sunny_day),
//                modifier = Modifier.size(100.dp),
//                contentDescription = "Sun"
//            )
//        }
//        //WEATHER DESCRIPTION
//        Column(
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier
//        ) {
//            Text("Sunny")
//            Text("")
//        }
//        HorizontalDivider(
//            thickness = 2.dp,
//            color = Color.Gray,
//            modifier = Modifier.padding(vertical = 8.dp)
//        )
//
//        Row(
//            horizontalArrangement = Arrangement.SpaceAround,
//            modifier = Modifier
//                .fillMaxWidth()
//        ) { Text("Thursday October 9th") }
//            Row(
//                horizontalArrangement = Arrangement.SpaceAround,
//                modifier = Modifier
//                    .fillMaxWidth()
//            ) {
//
//                Image(
//                    painter = painterResource(id = R.drawable.cloudy_day),
//                    modifier = Modifier.size(100.dp),
//                    contentDescription = "Sun and Clouds"
//                )
//            }
//            //WEATHER DESCRIPTION
//            Column(
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier
//            ) {
//                Text("Overcast")
//                Text("")
//            }
//            HorizontalDivider(
//                thickness = 2.dp,
//                color = Color.Gray,
//                modifier = Modifier.padding(vertical = 8.dp)
//            )
//            Row(
//                horizontalArrangement = Arrangement.SpaceAround,
//                modifier = Modifier
//                    .fillMaxWidth()
//            ) { Text("Friday October 10th") }
//
//            Row(
//                horizontalArrangement = Arrangement.SpaceAround,
//                modifier = Modifier
//                    .fillMaxWidth()
//            ) {
//
//                Image(
//                    painter = painterResource(id = R.drawable.rainy_day),
//                    modifier = Modifier.size(100.dp),
//                    contentDescription = "rain cloud"
//                )
//            }
//            //WEATHER DESCRIPTION
//            Column(
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier
//            ) {
//                Text("Heavy Rain")
//                Text("")
//            }
//            HorizontalDivider(
//                thickness = 2.dp,
//                color = Color.Gray,
//                modifier = Modifier.padding(vertical = 8.dp)
//            )
//
//
//        }
//    }









