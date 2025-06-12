package com.example.cinematicketbooking.ui.screen.movie_details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicketbooking.ui.theme.Avenir

@Composable
fun RatingsSection(modifier: Modifier = Modifier) {
    val ratings = listOf(
        Rating("IMDb", "6.8", "/10"),
        Rating("Rotten Tomatoes", "63%", ""),
        Rating("IGN", "4", "/10")
    )
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ratings.forEach { rating ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row {
                    Text(
                        text = rating.score,
                        fontFamily = Avenir,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp
                    )
                    Text(
                        text = rating.outOf,
                        fontFamily = Avenir,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = Color.Gray,
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = rating.source,
                    fontFamily = Avenir,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Color.Gray,
                )
            }
        }
    }
}

data class Rating(val source: String, val score: String, val outOf: String)