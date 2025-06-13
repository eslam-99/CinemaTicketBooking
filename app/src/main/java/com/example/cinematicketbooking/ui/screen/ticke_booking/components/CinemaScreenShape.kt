package com.example.cinematicketbooking.ui.screen.ticke_booking.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.cinematicketbooking.R

class CinemaScreenShape() : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            moveTo(0f, size.height * 0.2f)
            quadraticTo(x1 = size.width / 2, y1 = 0f, x2 = size.width, y2 = size.height * 0.2f)
            lineTo(size.width * 0.95f, size.height * 0.175f)
            lineTo(size.width * 0.8f, size.height)
            quadraticTo(
                x1 = size.width * 0.5f,
                y1 = size.height * 0.85f,
                x2 = size.width * 0.2f,
                y2 = size.height
            )
            lineTo(size.width * 0.05f, size.height * 0.175f)
            close()
        }
        return Outline.Generic(path)
    }
}

@Preview(showBackground = true)
@Composable
private fun CinemaScreenPreview() {
    Box(modifier = Modifier.background(Color.Black)) {
        Image(
            painter = painterResource(id = R.drawable.fantastic_beasts_image),
            contentDescription = "Movie Banner",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(467.dp, 122.dp)
                .topCurvedBorder(1.dp, Color(0xFF302D27), height = 24.dp)
                .clip(CinemaScreenShape())
        )
    }
}