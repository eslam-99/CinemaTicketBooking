package com.example.cinematicketbooking.ui.screen.movie_details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematicketbooking.R

@Composable
fun CastList() {
    val actorsImages = listOf(
        R.drawable.actor1,
        R.drawable.actor2,
        R.drawable.actor3,
        R.drawable.actor4,
        R.drawable.actor5,
        R.drawable.actor6,
        R.drawable.actor7,
        R.drawable.actor8,
    )
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 24.dp),
    ) {
        items(actorsImages.size) { index ->
            Image(
                painter = painterResource(id = actorsImages[index]),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }
    }
}