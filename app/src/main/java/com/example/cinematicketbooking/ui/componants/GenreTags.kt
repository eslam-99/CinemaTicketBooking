package com.example.cinematicketbooking.ui.componants

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GenreTags(genres: List<String>, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        genres.forEachIndexed { index, genre ->
            Chip(genre)
            if (index < genres.size - 1) {
                Spacer(Modifier.width(8.dp))
            }
        }
    }
}

@Composable
private fun Chip(text: String) {
    Box(
        modifier = Modifier
            .background(Color.White, RoundedCornerShape(30.dp))
            .border(1.dp, Color.Gray.copy(alpha = 0.2f), RoundedCornerShape(30.dp))
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Text(
            text,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 10.sp,
            color = Color.DarkGray,
        )
    }
}
