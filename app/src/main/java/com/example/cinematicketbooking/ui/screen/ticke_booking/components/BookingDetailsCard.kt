package com.example.cinematicketbooking.ui.screen.ticke_booking.components

import android.annotation.SuppressLint
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicketbooking.ui.theme.Avenir
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun BookingDetailsCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    topStart = 28.dp,
                    topEnd = 28.dp,
                )
            )
            .background(Color.White)
            .padding(horizontal = 24.dp)
            .padding(top = 24.dp)
    ) {
        var selectedDateIndex by remember { mutableIntStateOf(2) }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            itemsIndexed(getNextDays(20)) { index, day ->
                val dayTextColor = if (index == selectedDateIndex) Color.White else Color.Black
                val dayNameTextColor = if (index == selectedDateIndex) Color.White else Color.Gray
                val backgroundColor =
                    if (index == selectedDateIndex) Color(0xFF918B81) else Color.White
                val animatedDayTextColor by animateColorAsState(dayTextColor)
                val animatedDayStringTextColor by animateColorAsState(dayNameTextColor)
                val animatedBackgroundColor by animateColorAsState(backgroundColor)
                Column(
                    modifier = Modifier
                        .background(
                            animatedBackgroundColor,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .border(
                            1.dp,
                            color = Color.Gray.copy(0.2f),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 3.dp)
                        .padding(vertical = 12.dp)
                        .clickable {
                            selectedDateIndex = index
                        },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = day.first.toString(),
                        fontFamily = Avenir,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        color = animatedDayTextColor,
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                    )
                    Text(
                        text = day.second,
                        color = animatedDayStringTextColor,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .padding(top = 4.dp)
                    )
                }
            }
        }
        val times = listOf("10:00", "12:30", "15:30", "18:30", "21:30", "23:30")
        var selectedTimeIndex by remember { mutableIntStateOf(0) }
        LazyRow(
            modifier = Modifier.padding(top = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            itemsIndexed(times) { index, time ->
                val dayTextColor = if (index == selectedTimeIndex) Color.White else Color.Black
                val backgroundColor =
                    if (index == selectedTimeIndex) Color(0xFF918B81) else Color.White
                val animatedDayTextColor by animateColorAsState(dayTextColor)
                val animatedBackgroundColor by animateColorAsState(backgroundColor)
                Column(
                    modifier = Modifier
                        .background(
                            animatedBackgroundColor,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .border(
                            1.dp,
                            color = Color.Gray.copy(0.2f),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 3.dp)
                        .padding(vertical = 12.dp)
                        .clickable {
                            selectedTimeIndex = index
                        },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = time,
                        fontFamily = Avenir,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = animatedDayTextColor,
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(top = 2.dp)
                    )
                }
            }
        }
    }
}

@SuppressLint("NewApi")
private fun getNextDays(nDays: Int): List<Pair<Int, String>> {
    return (1..nDays).map { daysToAdd ->
        val dayOfMonth = LocalDate.now().plusDays(daysToAdd.toLong()).dayOfMonth
        val dayName = LocalDate.now()
            .plusDays(daysToAdd.toLong())
            .dayOfWeek
            .getDisplayName(TextStyle.SHORT_STANDALONE, Locale.getDefault())
        Pair(dayOfMonth, dayName)
    }
}