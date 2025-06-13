package com.example.cinematicketbooking.ui.screen.ticke_booking.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import com.example.cinematicketbooking.ui.screen.ticke_booking.model.CinemaPairSeat

@Composable
fun CinemaSeatCouple(
    seatPair: CinemaPairSeat,
    rotation: Float,
    modifier: Modifier = Modifier,
    onSeatClick: (seatRow: Int, seatCol: Int, isLeft: Boolean) -> Unit,
) {
    Row(
        modifier = modifier.rotate(rotation),
        horizontalArrangement = Arrangement.Center,
    ) {
        CinemaLeftSeat(state = seatPair.leftSeat.seatState) {
            onSeatClick(
                seatPair.row,
                seatPair.column,
                true
            )
        }
        CinemaRightSeat(state = seatPair.rightSeat.seatState) {
            onSeatClick(
                seatPair.row,
                seatPair.column,
                false
            )
        }
    }
}