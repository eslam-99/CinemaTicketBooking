package com.example.cinematicketbooking.ui.componants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cinematicketbooking.R

@Composable
fun CloseButton(size: Dp = 40.dp) {
    Icon(
        painter = painterResource(R.drawable.close),
        contentDescription = "Close",
        tint = Color(0xFFFFFFFF),
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .background(Color(0xFF363636).copy(0.6f))
            .padding(7.dp)
    )
}