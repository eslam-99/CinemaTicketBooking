package com.example.cinematicketbooking.ui.screen.ticke_booking.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cinematicketbooking.ui.screen.ticke_booking.model.CinemaPairSeat

@Composable
fun SeatingChart(
    seats: List<List<CinemaPairSeat>>,
    modifier: Modifier = Modifier,
    onSeatClick: (seatRow: Int, seatCol: Int, isLeft: Boolean) -> Unit,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val seatCoupleModifier = Modifier
            .weight(1f)
            .align(Alignment.CenterHorizontally)
        seats.forEach { seatsRow ->
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                seatsRow.forEachIndexed { index, seatPair ->
                    if (index == 0) {
                        CinemaSeatCouple(
                            seatPair,
                            rotation = 12f,
                            modifier = seatCoupleModifier,
                            onSeatClick = onSeatClick,
                        )
                    } else if (index == seatsRow.size - 1) {
                        CinemaSeatCouple(
                            seatPair,
                            rotation = -12f,
                            modifier = seatCoupleModifier,
                            onSeatClick = onSeatClick,
                        )
                    } else {
                        CinemaSeatCouple(
                            seatPair,
                            rotation = 0f,
                            modifier = seatCoupleModifier.padding(top = 22.dp),
                            onSeatClick = onSeatClick,
                        )
                    }
                }
            }
        }
    }
}