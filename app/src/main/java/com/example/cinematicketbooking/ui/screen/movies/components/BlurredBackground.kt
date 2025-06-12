package com.example.cinematicketbooking.ui.screen.movies.components

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematicketbooking.ui.screen.movies.models.MovieUiModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BlurredBackground(movies: List<MovieUiModel>, pagerState: PagerState) {
    Box {
        Crossfade(targetState = pagerState.currentPage, label = "background_cross_fade") { page ->
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = movies[page].posterResId),
                    contentDescription = "Blurred background",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .blur(radius = 80.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colorStops = arrayOf(
                            0.0f to Color.Transparent,
                            0.2f to Color.Transparent,
                            0.4f to Color.White.copy(0.5f),
                            0.5f to Color.White,
                            1.0f to Color.White,
                        )
                    )
                )
        )
    }
}