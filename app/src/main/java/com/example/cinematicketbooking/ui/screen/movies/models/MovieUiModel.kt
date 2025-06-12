package com.example.cinematicketbooking.ui.screen.movies.models

data class MovieUiModel(
    val title: String,
    val posterResId: Int,
    val duration: String,
    val genres: List<String>
)
