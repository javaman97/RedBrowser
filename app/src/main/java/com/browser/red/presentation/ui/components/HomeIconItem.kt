package com.browser.red.presentation.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.browser.red.R
import com.browser.red.domain.model.HomeIcon
import com.browser.red.ui.theme.Dimensions
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview
@Composable
fun HomeIconPreview(){
    val icon = HomeIcon(imageId = R.drawable.facebook_color_svgrepo_com)
    HomeIconItem(1,icon)
}

@Composable
fun HomeIconItem(index: Int, homeIcon: HomeIcon, onIconClicked: (HomeIcon) -> Unit = {}) {
    val screenWidthDp = LocalConfiguration.current.screenWidthDp
    val screenWidthPx = with(LocalDensity.current) { screenWidthDp.dp.toPx() }
    val offsetX = remember { Animatable(screenWidthPx) }
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(index) {
        delay(index * 100L)
        isVisible = true

        launch {
            offsetX.animateTo(
                targetValue = 0f,
                animationSpec = tween(durationMillis = 500)
            )
        }
    }
    if (isVisible) {
        Card(
            elevation = CardDefaults.elevatedCardElevation(3.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .offset { IntOffset(offsetX.value.toInt(), 0) } // Use animated X offset
                .clickable { onIconClicked(homeIcon) }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f)),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White),
                    model = homeIcon.imageId,
                    contentDescription = homeIcon.contentDescription,
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}