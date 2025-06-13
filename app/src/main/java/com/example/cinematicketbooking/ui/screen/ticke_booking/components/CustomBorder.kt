package com.example.cinematicketbooking.ui.screen.ticke_booking.components

import android.annotation.SuppressLint
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp

@SuppressLint("UnnecessaryComposedModifier")
fun Modifier.bottomLeftCurvedBorder(
    strokeWidth: Dp,
    color: Color,
    cornerRadius: Dp
): Modifier = composed {
    drawBehind {
        val width = size.width
        val height = size.height
        val strokeWidthPx = strokeWidth.toPx()
        val cornerRadiusPx = cornerRadius.toPx()

        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo(0f, height - cornerRadiusPx)
            quadraticTo(x1 = 0f, y1 = height, x2 = cornerRadiusPx, y2 = height)
            lineTo(width, height)
        }

        drawPath(
            path = path,
            color = color,
            style = Stroke(width = strokeWidthPx)
        )
    }
}

@SuppressLint("UnnecessaryComposedModifier")
fun Modifier.bottomRightCurvedBorder(
    strokeWidth: Dp,
    color: Color,
    cornerRadius: Dp
): Modifier = composed {
    drawBehind {
        val width = size.width
        val height = size.height
        val strokeWidthPx = strokeWidth.toPx()
        val cornerRadiusPx = cornerRadius.toPx()

        val path = Path().apply {
            moveTo(width, 0f)
            lineTo(width, height - cornerRadiusPx)
            quadraticTo(x1 = width, y1 = height, x2 = width - cornerRadiusPx, y2 = height)
            lineTo(0f, height)
        }

        drawPath(
            path = path,
            color = color,
            style = Stroke(width = strokeWidthPx),
        )
    }
}

@SuppressLint("UnnecessaryComposedModifier")
fun Modifier.topCurvedBorder(
    strokeWidth: Dp,
    color: Color,
    height: Dp? = null,
): Modifier = composed {
    drawBehind {
        val heightPx = height?.toPx() ?: (size.height * 0.175f)
        val strokeWidthPx = strokeWidth.toPx()

        val path = Path().apply {
            moveTo(0f, heightPx)
            quadraticTo(x1 = size.width / 2, y1 = 0f, x2 = size.width, y2 = heightPx)
        }

        drawPath(
            path = path,
            color = color,
            style = Stroke(width = strokeWidthPx),
        )
    }
}