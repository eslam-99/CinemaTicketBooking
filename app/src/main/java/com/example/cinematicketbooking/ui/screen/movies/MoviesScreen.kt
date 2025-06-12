package com.example.cinematicketbooking.ui.screen.movies

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematicketbooking.R
import com.example.cinematicketbooking.ui.componants.AppBottomNavigation
import com.example.cinematicketbooking.ui.screen.movies.components.BlurredBackground
import com.example.cinematicketbooking.ui.screen.movies.components.MovieDetailsCard
import com.example.cinematicketbooking.ui.screen.movies.components.MoviePosterPager
import com.example.cinematicketbooking.ui.screen.movies.components.MoviesStatusesRow
import com.example.cinematicketbooking.ui.screen.movies.models.MovieUiModel

@Composable
fun MoviesScreen() {
    MoviesContent()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesContent() {
    val pagerState = rememberPagerState { movies.size }

    Column(
        modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color(0xFF1C1C1E))
        ) {
            BlurredBackground(movies = movies, pagerState = pagerState)
            Column(Modifier.fillMaxSize()) {
                MoviesStatusesRow(Modifier.padding(top = 70.dp))
                MoviePosterPager(
                    movies = movies,
                    pagerState = pagerState,
                    Modifier.padding(top = 40.dp)
                )
                MovieDetailsCard(
                    movies = movies,
                    pagerState = pagerState,
                    Modifier.padding(top = 16.dp)
                )
            }
        }
        AppBottomNavigation()
    }
}

@Preview
@Composable
private fun MoviesScreenPreview() {
    MoviesContent()
}

private val movies = listOf(
    MovieUiModel(
        "Morbius",
        R.drawable.morbius,
        "2h 56m",
        listOf("Action", "Crime", "Drama")
    ),
    MovieUiModel(
        "Fantastic Beasts: The Secrets of Dumbledore",
        R.drawable.fantastic_beasts,
        "2h 23m",
        listOf("Fantasy", "Adventure")
    ),
    MovieUiModel(
        "Doctor Strange in the Multiverse of Madness",
        R.drawable.dr_strange,
        "2h 6m",
        listOf("Action", "Fantasy")
    ),
)