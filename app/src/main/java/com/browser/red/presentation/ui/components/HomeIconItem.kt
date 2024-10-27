package com.browser.red.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.browser.red.R
import com.browser.red.domain.model.HomeIcon
import com.browser.red.ui.theme.Dimensions

@Preview
@Composable
fun HomeIconPreview(){
    val icon = HomeIcon(imageId = R.drawable.facebook_color_svgrepo_com)
    HomeIconItem(icon)
}

@Composable
fun HomeIconItem(homeIcon: HomeIcon, onIconClicked:(icon:HomeIcon)->Unit={}) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(3.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clickable {
                onIconClicked(homeIcon)
            }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Dimensions.LargePadding)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White),
                painter = painterResource(id = homeIcon.imageId),
                contentDescription = homeIcon.contentDescription,
                contentScale = ContentScale.Fit
            )
        }
    }
}


