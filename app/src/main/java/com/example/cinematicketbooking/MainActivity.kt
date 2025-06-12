package com.example.cinematicketbooking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.cinematicketbooking.ui.screen.movie_details.MovieDetailsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(0xFFFFFF),
//            navigationBarStyle = SystemBarStyle.dark(0xFFFFFF),
        )
        setContent {
            MovieDetailsScreen()
        }
    }
}
