package com.example.cinematicketbooking.ui.screen.movie_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematicketbooking.R

@Composable
fun BoxWithConstraintsScope.MovieTrailerPlayButton() {
    Icon(
        painter = painterResource(R.drawable.play),
        contentDescription = "Play Trailer",
        tint = Color(0xFFFFFFFF),
        modifier = Modifier
            .align(Alignment.Center)
            .padding(bottom = this.maxHeight * 0.47f)
            .size(56.dp)
            .clip(CircleShape)
            .background(Color(0xFFFA5135))
            .padding(15.dp)
    )
}