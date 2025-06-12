package com.example.cinematicketbooking.ui.screen.movies.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MoviesStatusesRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        MoviesStatus("Now Showing", true)
        Spacer(Modifier.width(5.dp))
        MoviesStatus("Coming Soon", false)
    }
}

@Composable
private fun MoviesStatus(label: String, isSelected: Boolean) {
    Text(
        text = label,
        fontSize = 16.sp,
        color = Color.White,
        modifier = (if (isSelected) Modifier
            .background(Color(0xFFFA5234), shape = RoundedCornerShape(20.dp))
        else Modifier
            .border(1.dp, Color.Gray.copy(0.4f), shape = RoundedCornerShape(20.dp))
                )
            .padding(vertical = 10.dp, horizontal = 20.dp)
    )
}
