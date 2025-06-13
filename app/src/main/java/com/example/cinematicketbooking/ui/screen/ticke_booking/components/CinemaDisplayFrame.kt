//package com.example.cinematicketbooking.ui.screen.ticke_booking.components
//
//import android.graphics.Canvas
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.StrokeCap
//import androidx.compose.ui.graphics.drawscope.Stroke
//import androidx.compose.ui.unit.dp
//import kotlin.io.path.Path
//import kotlin.io.path.moveTo
//
//@Composable
//fun CinemaScreen() {
//    Canvas(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(50.dp)
//            .padding(horizontal = 32.dp)
//    ) {
//        val path = Path("").apply {
//            // Start from the left
//            moveTo(0f, size.height)
//            // Draw a quadratic curve up to the center top and back down
//            quadraticBezierTo(
//                x1 = size.width / 2, y1 = 0f,
//                x2 = size.width, y2 = size.height
//            )
//        }
//        drawPath(
//            path = path,
//            color = Color.White,
//            style = Stroke(width = 4f, cap = StrokeCap.Round)
//        )
//    }
//}