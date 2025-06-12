package com.example.cinematicketbooking.ui.componants

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematicketbooking.R

@Composable
fun AppBottomNavigation(modifier: Modifier = Modifier) {
    var selectedItem = remember { mutableIntStateOf(0) }
    val tabs = listOf(
        painterResource(R.drawable.movie),
        painterResource(R.drawable.search),
        painterResource(R.drawable.ticket),
        painterResource(R.drawable.profile),
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(bottom = 24.dp)
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        tabs.forEachIndexed { index, icon ->
            val isSelected = selectedItem.intValue == index
            if (index == 2) {
                BadgedBox(
                    badge = {
                        Badge(
                            modifier = Modifier.offset(
                                x = 10.dp,
                                y = 12.dp,
                            ),
                            containerColor = Color(0xFFF46E45),
                        ) {
                            Text(
                                text = "5",
                                color = Color.White,
                            )
                        }
                    }
                ) {
                    Icon(
                        icon,
                        contentDescription = null,
                        modifier = if (isSelected) Modifier
                            .size(50.dp)
                            .background(Color(0xFFF85335), shape = CircleShape)
                            .padding(11.dp)
                            .clickable {
                                selectedItem.intValue = index
                            }
                        else Modifier.background(Color.Transparent)
                    )
                }
            } else {
                Icon(
                    icon,
                    contentDescription = null,
                    tint = if (isSelected) Color.White else Color(0xFF090909),
                    modifier = if (isSelected) Modifier
                        .size(50.dp)
                        .background(Color(0xFFF85335), shape = CircleShape)
                        .padding(11.dp)
                        .clickable {
                            selectedItem.intValue = index
                        }
                    else Modifier.background(Color.Transparent)
                )
            }
        }
    }
}