package com.example.cinematicketbooking.ui.screen.movie_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicketbooking.R
import com.example.cinematicketbooking.ui.componants.CloseButton
import com.example.cinematicketbooking.ui.theme.Avenir

@Composable
fun TopBarControls() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CloseButton()
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .background(Color(0xFF363636).copy(0.6f))
                .padding(7.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(R.drawable.time),
                contentDescription = "Close",
                tint = Color(0xFF7D8B8A),
                modifier = Modifier
                    .size(18.dp)
            )
            Text(
                text = "2h 23m",
                fontFamily = Avenir,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 4.sp,
                color = Color(0xFFFFFFFF),
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .padding(top = 2.dp)
            )
        }
    }
}