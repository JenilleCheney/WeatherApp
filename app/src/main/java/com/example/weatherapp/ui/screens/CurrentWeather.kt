package com.example.weatherapp.ui.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.weatherapp.MainViewModel

//@Preview
@Composable
fun CurrentWeather(mainViewModel: MainViewModel) {

    val weather by mainViewModel.weather.collectAsState()

    val current = weather?.current

    if (current != null) {


        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp)

        ) {
            //title of weather
            Text(
                text = current.condition.text,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

           Image(
                painter = rememberAsyncImagePainter("https:${current.condition.icon}"),
                contentDescription = "Weather Icon",
                modifier = Modifier
                    .size(200.dp)
            )
            Text(
                text = "${current.temperature} °C",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Feels like: ${current.feelsLike} °C",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center

            )
            Text(
                text = "💧Precip: ${current.precipitationAmount} mm "
            )

            Text(
                text = "💨 Wind: ${current.windSpeed} kph | Direction: ${current.windDirection}",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )

        }
    }
}

//    Column(
//        //BACKGROUND!!!!!!!!!
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//    )
//    {
//        Row(
//            horizontalArrangement = Arrangement.SpaceAround,
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.sun_showers),
//                contentDescription = "Android Logo"
//            )
//        }
//        //WEATHER DESCRIPTION
//        Column(
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier
//        ){
//            Text("")
//            Text("Sun Showers")
//            Text("20°C")
//            Text("feels like 18°C")
//            Text("Wind NE 10 kph")
//
//        }
//    }
//}


