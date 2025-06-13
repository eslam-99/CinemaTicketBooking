package com.example.cinematicketbooking.ui.screen.ticke_booking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematicketbooking.R
import com.example.cinematicketbooking.ui.componants.CloseButton
import com.example.cinematicketbooking.ui.screen.ticke_booking.components.BookingBottomBar
import com.example.cinematicketbooking.ui.screen.ticke_booking.components.BookingDetailsCard
import com.example.cinematicketbooking.ui.screen.ticke_booking.components.ImageAsCinemaScreen
import com.example.cinematicketbooking.ui.screen.ticke_booking.components.SeatingChart
import com.example.cinematicketbooking.ui.screen.ticke_booking.components.SeatsTypesRow
import com.example.cinematicketbooking.ui.screen.ticke_booking.model.CinemaPairSeat
import com.example.cinematicketbooking.ui.screen.ticke_booking.model.CinemaSeat
import com.example.cinematicketbooking.ui.screen.ticke_booking.model.SeatState

@Composable
fun TicketBookingScreen() {
    TicketBookingContent()
}

@Composable
fun TicketBookingContent() {
    val ticketPrice = 25f
    var selectedSeatsCount by remember { mutableIntStateOf(4) }
    val cinemaSeats = remember {
        cinemaSeatsData.map { row -> row.toMutableStateList() }.toMutableStateList()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .windowInsetsPadding(WindowInsets.statusBars)
            .windowInsetsPadding(WindowInsets.navigationBars),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .padding(top = 24.dp)
            ) {
                CloseButton(size = 45.dp)
            }
            ImageAsCinemaScreen(painterResource(id = R.drawable.fantastic_beasts_image))
            SeatingChart(
                cinemaSeats,
                Modifier
                    .padding(horizontal = 24.dp)
                    .padding(top = 24.dp)
            ) { row, col, isLeftSeat ->
                val rowIndex = row - 1
                val colIndex = col - 1
                val seat = cinemaSeats[rowIndex][colIndex]
                if (seat.leftSeat.seatState == SeatState.Taken) return@SeatingChart
                if (isLeftSeat) {
                    var newSeatState = if (seat.leftSeat.seatState == SeatState.Selected) {
                        selectedSeatsCount--
                        SeatState.Available
                    } else {
                        selectedSeatsCount++
                        SeatState.Selected
                    }
                    cinemaSeats[rowIndex][colIndex] = seat.copy(
                        leftSeat = seat.leftSeat.copy(seatState = newSeatState)
                    )
                } else {
                    var newSeatState = if (seat.rightSeat.seatState == SeatState.Selected) {
                        selectedSeatsCount--
                        SeatState.Available
                    } else {
                        selectedSeatsCount++
                        SeatState.Selected
                    }
                    cinemaSeats[rowIndex][colIndex] = seat.copy(
                        rightSeat = seat.rightSeat.copy(seatState = newSeatState)
                    )
                }
            }
            SeatsTypesRow(
                Modifier
                    .padding(horizontal = 24.dp)
                    .padding(top = 32.dp)
            )

            BookingDetailsCard(
                Modifier
                    .padding(top = 32.dp)
                    .weight(1f)
            )
        }
        BookingBottomBar(selectedSeatsCount, ticketPrice)
    }
}

private val cinemaSeatsData = listOf(
    listOf(
        CinemaPairSeat(1, 1, CinemaSeat(SeatState.Available), CinemaSeat(SeatState.Available)),
        CinemaPairSeat(1, 2, CinemaSeat(SeatState.Available), CinemaSeat(SeatState.Available)),
        CinemaPairSeat(1, 3, CinemaSeat(SeatState.Taken), CinemaSeat(SeatState.Available)),
    ),
    listOf(
        CinemaPairSeat(2, 1, CinemaSeat(SeatState.Available), CinemaSeat(SeatState.Available)),
        CinemaPairSeat(2, 2, CinemaSeat(SeatState.Selected), CinemaSeat(SeatState.Selected)),
        CinemaPairSeat(2, 3, CinemaSeat(SeatState.Available), CinemaSeat(SeatState.Available)),
    ),
    listOf(
        CinemaPairSeat(3, 1, CinemaSeat(SeatState.Available), CinemaSeat(SeatState.Available)),
        CinemaPairSeat(3, 2, CinemaSeat(SeatState.Selected), CinemaSeat(SeatState.Selected)),
        CinemaPairSeat(3, 3, CinemaSeat(SeatState.Available), CinemaSeat(SeatState.Available)),
    ),
    listOf(
        CinemaPairSeat(4, 1, CinemaSeat(SeatState.Available), CinemaSeat(SeatState.Available)),
        CinemaPairSeat(4, 2, CinemaSeat(SeatState.Available), CinemaSeat(SeatState.Available)),
        CinemaPairSeat(4, 3, CinemaSeat(SeatState.Available), CinemaSeat(SeatState.Available)),
    ),
    listOf(
        CinemaPairSeat(5, 1, CinemaSeat(SeatState.Available), CinemaSeat(SeatState.Available)),
        CinemaPairSeat(5, 2, CinemaSeat(SeatState.Available), CinemaSeat(SeatState.Available)),
        CinemaPairSeat(5, 3, CinemaSeat(SeatState.Available), CinemaSeat(SeatState.Available)),
    )
)