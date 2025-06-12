package com.example.cinematicketbooking.ui.screen.movie_details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicketbooking.R

@Composable
fun ColumnScope.BookingButton() {
    Button(
        onClick = { },
        shape = RoundedCornerShape(32.dp),
        contentPadding = PaddingValues(horizontal = 22.dp, vertical = 15.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFA5135)),
        modifier = Modifier
            .padding(bottom = 20.dp)
            .align(Alignment.CenterHorizontally),
    ) {
        Image(
            painter = painterResource(R.drawable.credit),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color.White),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(24.dp)
                .height(26.dp)
        )
        Text(
            text = "Booking",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(start = 12.dp)
        )
    }
}