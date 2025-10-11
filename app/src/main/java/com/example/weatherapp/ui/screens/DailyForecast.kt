package com.example.weatherapp.ui.screens

//import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.MainViewModel

//@Preview
@Composable
fun DailyForecast (mainViewModel : MainViewModel) {
    val weather by mainViewModel.weather.collectAsState()

    // DailyForecast variables
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ){
        // List each forecast day in 3-day forecast
        for(item in weather?.forecast!!){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
                )

                Text(
                    text = item.date,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(top = 10.dp)
                )

                Image(
                    painter = painterResource(id = item.imageId),
                    contentDescription = "Forecast Icon",
                    modifier = Modifier.size(40.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {


                    Text(
                        text = item.temperatureHigh,
                        style = MaterialTheme.typography.titleSmall
                    )

                    Text(
                        text = item.temperatureLow,
                        style = MaterialTheme.typography.titleSmall
                    )
                }

                Text(
                    text = item.condition,
                    style = MaterialTheme.typography.titleSmall
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {


                    Text(
                        text = item.precipitationType,
                        style = MaterialTheme.typography.titleSmall
                    )

                    Text(
                        text = item.precipitationAmount,
                        style = MaterialTheme.typography.titleSmall
                    )

                    Text(
                        text = item.precipitationProbability,
                        style = MaterialTheme.typography.titleSmall
                    )
                }

                Text(
                    text = item.wind,
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    text = item.humidity,
                    style = MaterialTheme.typography.titleSmall
                )

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









