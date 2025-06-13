package com.example.cinematicketbooking.ui.screen.movies.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.example.cinematicketbooking.ui.screen.movies.models.MovieUiModel
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviePosterPager(
    movies: List<MovieUiModel>,
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 67.dp),
        modifier = modifier.fillMaxWidth()
    ) { page ->
        val pageOffset =
            (pagerState.currentPage - page).toFloat() + pagerState.currentPageOffsetFraction

        val scaleFactor = lerp(
            start = 0.9f,
            stop = 1f,
            fraction = 1f - pageOffset.absoluteValue.coerceIn(0f, 1f)
        )

        Card(
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scaleFactor
                    scaleY = scaleFactor
                }
                .aspectRatio(0.66f),
            shape = RoundedCornerShape(28.dp)
        ) {
            Image(
                painter = painterResource(id = movies[page].posterResId),
                contentDescription = movies[page].title,
                contentScale = ContentScale.Crop
            )
        }
    }
}