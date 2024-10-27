package com.browser.red.presentation.ui.screens

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.browser.red.R
import com.browser.red.domain.model.HomeIcon
import com.browser.red.presentation.ui.components.HomeIconItem
import com.browser.red.presentation.viewmodel.HomeDefaultScreenViewModel
import com.browser.red.presentation.viewmodel.MainActivityViewModel
import com.browser.red.ui.theme.Dimensions
import com.browser.red.ui.theme.Orange700
import com.browser.red.ui.theme.Red800

@Preview()
@Composable
fun HomeDefaultScreenPreview(){
    HomeDefaultScreen()
}

@Composable
fun HomeDefaultScreen(
    homeDefaultScreenViewModel: HomeDefaultScreenViewModel = hiltViewModel(),
    onHomeIconClicked:(HomeIcon)->Unit = {}
    ) {
    val infiniteTransition = rememberInfiniteTransition(label = "")

    val animatedOffsetY by infiniteTransition.animateFloat(
        initialValue = 500f,
        targetValue = 2000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 5000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    val brush = Brush.linearGradient(
        colors = listOf(Red800, Orange700),
        start = Offset(x = 0f, y = 0f),
        end = Offset(x = 0f, y = animatedOffsetY)
    )
    Box(
        modifier = Modifier
            .background(brush)
            .fillMaxSize()
            .padding(vertical = Dimensions.MediumPadding)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(homeDefaultScreenViewModel.getIcons()){index,icon ->
                HomeIconItem(index,icon){
                    onHomeIconClicked(it)
                }
            }
        }
    }
}

