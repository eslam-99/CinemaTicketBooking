package com.example.cinematicketbooking.ui.screen.movie_details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematicketbooking.R

@Composable
fun BoxWithConstraintsScope.PosterImage() {
    Image(
        painter = painterResource(id = R.drawable.fantastic_beasts_banner),
        contentDescription = "Fantastic Beasts Poster",
        modifier = Modifier
            .fillMaxWidth()
            .height(this.maxHeight * 0.5f + 28.dp),
        contentScale = ContentScale.Crop
    )
}