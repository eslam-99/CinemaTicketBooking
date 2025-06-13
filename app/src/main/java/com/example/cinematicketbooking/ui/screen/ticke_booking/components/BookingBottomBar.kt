package com.example.cinematicketbooking.ui.screen.ticke_booking.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.cinematicketbooking.ui.theme.Avenir

@Composable
fun BookingBottomBar(selectedSeatsCount: Int, ticketPrice: Float) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 24.dp)
            .padding(bottom = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TicketsPriceColumn(selectedSeatsCount, ticketPrice)
        BuyTicketsButton()
    }
}

@Composable
private fun TicketsPriceColumn(selectedSeatsCount: Int, ticketPrice: Float) {
    Column {
        Text(
            text = "\$${selectedSeatsCount * ticketPrice}.00",
            fontFamily = Avenir,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = Color.Black
        )
        Text(
            text = "$selectedSeatsCount tickets",
            fontFamily = Avenir,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
private fun BuyTicketsButton() {
    Button(
        onClick = { },
        shape = RoundedCornerShape(32.dp),
        contentPadding = PaddingValues(horizontal = 22.dp, vertical = 15.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFA5135)),
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
            text = "Buy Tickets",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(start = 12.dp)
        )
    }
}