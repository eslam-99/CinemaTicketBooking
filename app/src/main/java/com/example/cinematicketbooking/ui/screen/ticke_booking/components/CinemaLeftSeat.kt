package com.example.cinematicketbooking.ui.screen.ticke_booking.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematicketbooking.R
import com.example.cinematicketbooking.ui.screen.ticke_booking.model.SeatState

@Composable
fun CinemaLeftSeat(
    state: SeatState,
    onClick: () -> Unit
) {
    val seatColor by animateColorAsState(
        when (state) {
            SeatState.Available -> Color(0xFFFFFFFF)
            SeatState.Taken -> Color(0xFF434343)
            SeatState.Selected -> Color(0xFFFA5236)
        }
    )

    val borderColor by animateColorAsState(
        when (state) {
            SeatState.Available -> Color(0xFF363636)
            SeatState.Taken -> Color(0xFF202020)
            SeatState.Selected -> Color(0xFF3F231C)
        }
    )

    Image(
        painter = painterResource(id = R.drawable.cenima_seat),
        contentDescription = "Cinema Seat",
        colorFilter = ColorFilter.tint(seatColor),
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .bottomLeftCurvedBorder(
                strokeWidth = 4.dp,
                color = borderColor,
                cornerRadius = 14.dp
            )
            .padding(start = 6.dp, end = 1.dp)
            .size(34.dp)
            .offset(y = (-3).dp)
            .clickable(onClick = onClick)
    )
}

@Composable
fun CinemaRightSeat(
    state: SeatState,
    onClick: () -> Unit
) {
    val seatColor by animateColorAsState(
        when (state) {
            SeatState.Available -> Color(0xFFFFFFFF)
            SeatState.Taken -> Color(0xFF434343)
            SeatState.Selected -> Color(0xFFFA5236)
        }
    )

    val borderColor by animateColorAsState(
        when (state) {
            SeatState.Available -> Color(0xFF363636)
            SeatState.Taken -> Color(0xFF202020)
            SeatState.Selected -> Color(0xFF3F231C)
        }
    )

    Image(
        painter = painterResource(id = R.drawable.cenima_seat),
        contentDescription = "Cinema Seat",
        colorFilter = ColorFilter.tint(seatColor),
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .bottomRightCurvedBorder(
                strokeWidth = 4.dp,
                color = borderColor,
                cornerRadius = 14.dp
            )
            .padding(end = 6.dp, start = 1.dp)
            .size(34.dp)
            .offset(y = (-3).dp)
            .clickable(onClick = onClick)
    )
}