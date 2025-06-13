package com.example.cinematicketbooking.ui.screen.ticke_booking.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@Composable
fun ImageAsCinemaScreen(painter: Painter) {
    Image(
        painter = painter,
        contentDescription = "Movie Banner",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth()
            .aspectRatio(3.8f)
            .size(467.dp, 122.dp)
            .topCurvedBorder(1.dp, Color(0xFF302D27))
            .clip(CinemaScreenShape())
    )
}