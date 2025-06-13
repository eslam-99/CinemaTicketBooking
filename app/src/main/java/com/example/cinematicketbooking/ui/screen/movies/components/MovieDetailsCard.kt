package com.example.cinematicketbooking.ui.screen.movies.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicketbooking.R
import com.example.cinematicketbooking.ui.componants.GenreTags
import com.example.cinematicketbooking.ui.screen.movies.models.MovieUiModel
import com.example.cinematicketbooking.ui.theme.Avenir

@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
@Composable
fun MovieDetailsCard(
    movies: List<MovieUiModel>,
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    val currentMovie = movies[pagerState.currentPage]

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            .background(Color.White)
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(7.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(R.drawable.time),
                contentDescription = "Close",
                tint = Color(0xFF7D8B8A),
                modifier = Modifier.size(18.dp)
            )
            AnimatedContent(
                targetState = currentMovie.duration,
                transitionSpec = {
                    (fadeIn(tween(800)) + slideInHorizontally(tween(200)) { x -> x / 10 }).togetherWith(
                        fadeOut(tween(0))
                    )
                }
            ) { duration ->
                Text(
                    text = duration,
                    fontFamily = Avenir,
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    lineHeight = 4.sp,
                    color = Color(0xFF000000),
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .padding(top = 2.dp)
                )
            }
        }
        AnimatedContent(
            targetState = currentMovie.title,
            transitionSpec = {
                (fadeIn(tween(800)) + slideInHorizontally(tween(200)) { x -> x / 10 }).togetherWith(
                    fadeOut(tween(0))
                )
            },
            modifier = Modifier.padding(top = 10.dp)
        ) { title ->
            Text(
                text = title,
                fontFamily = Avenir,
                fontWeight = FontWeight.Medium,
                fontSize = 28.sp,
                lineHeight = 34.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(horizontal = 28.dp)
                    .fillMaxWidth()
            )
        }
        AnimatedContent(
            targetState = currentMovie.genres,
            transitionSpec = {
                (fadeIn(tween(800)) + slideInHorizontally(tween(200)) { x -> x / 10 }).togetherWith(
                    fadeOut(tween(0))
                )
            },
            modifier = Modifier.padding(top = 18.dp)
        ) { genres ->
            GenreTags(genres, Modifier.padding(horizontal = 28.dp))
        }
    }
}