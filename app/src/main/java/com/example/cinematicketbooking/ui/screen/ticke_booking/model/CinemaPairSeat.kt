package com.example.cinematicketbooking.ui.screen.ticke_booking.model

data class CinemaPairSeat(
    val row: Int,
    val column: Int,
    val leftSeat: CinemaSeat,
    val rightSeat: CinemaSeat,
)

data class CinemaSeat(
    val seatState: SeatState
)

enum class SeatState { Available, Taken, Selected }