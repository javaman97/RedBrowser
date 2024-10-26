package com.browser.red.presentation.ui.screens

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.browser.red.ui.theme.Gray400
import com.browser.red.ui.theme.Gray600
import com.browser.red.ui.theme.Gray800
import com.browser.red.ui.theme.Red300
import com.browser.red.ui.theme.Red400
import com.browser.red.ui.theme.Red800
import com.browser.red.ui.theme.Red900

@Preview()
@Composable
fun HomeDefaultScreenPreview(){
    HomeDefaultScreen()
}

@Composable
fun HomeDefaultScreen() {
    val infiniteTransition = rememberInfiniteTransition(label = "")

    val animatedOffsetY by infiniteTransition.animateFloat(
        initialValue = 1000f,
        targetValue = 2000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 5000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    val brush = Brush.linearGradient(
        colors = listOf(Red900, Red300),
        start = Offset(x = 0f, y = 0f),
        end = Offset(x = 0f, y = animatedOffsetY)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush)
    ) {
        // Your UI content goes here
    }
}
