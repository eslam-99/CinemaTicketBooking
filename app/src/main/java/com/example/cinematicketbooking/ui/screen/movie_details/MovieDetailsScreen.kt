package com.example.cinematicketbooking.ui.screen.movie_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.cinematicketbooking.ui.screen.movie_details.components.BookingButton
import com.example.cinematicketbooking.ui.screen.movie_details.components.MovieInfo
import com.example.cinematicketbooking.ui.screen.movie_details.components.MovieTrailerPlayButton
import com.example.cinematicketbooking.ui.screen.movie_details.components.PosterImage
import com.example.cinematicketbooking.ui.screen.movie_details.components.TopBarControls

@Composable
fun MovieDetailsScreen() {
    MovieDetailsContent()
}

@Composable
fun MovieDetailsContent() {
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(Color.White)
            .windowInsetsPadding(WindowInsets.navigationBars)
    ) {
        BoxWithConstraints(
            modifier = Modifier.weight(1f)
        ) {
            PosterImage()
            TopBarControls()
            MovieTrailerPlayButton()
            MovieInfo(height = this.maxHeight)
        }
        BookingButton()
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun MoviesScreenPreview() {
    MovieDetailsContent()
}