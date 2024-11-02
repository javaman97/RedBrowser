package com.browser.red.presentation.ui.components

import android.webkit.WebView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.browser.core_browser.domain.model.RedBrowserTab
import com.browser.red.R
import com.browser.red.domain.utils.extractBaseDomain
import com.browser.red.ui.theme.Dimensions

@Preview
@Composable
fun RedBrowserTabPreview(){
    val context = LocalContext.current
    val tab = RedBrowserTab(
        webView = WebView(context),
        url = "google.com"
    )
    RedBrowserTabItem(tab)
}
@Composable
fun RedBrowserTabItem(
    tab:RedBrowserTab,
    onClick:()->Unit = {},
    closable:Boolean = false,
    onClose:(tab:RedBrowserTab)->Unit = {},
    ){
    val sizeDp = DpSize(width = 120.dp, height = 150.dp)
    Card (elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .padding(Dimensions.MediumPadding)
            .size(sizeDp)


    ) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .clickable { onClick() }
        ){
            Column(
                modifier = Modifier
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    model = tab.thumbnail ?: R.drawable.face_with_tongue_svgrepo_com,
                    contentDescription = "testing",
                    contentScale = ContentScale.Crop
                )
                Text(
                    modifier = Modifier
                        .padding(horizontal = Dimensions.SmallPadding),
                    text = tab.url.extractBaseDomain(),
                    style = MaterialTheme.typography.labelSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
           if(closable){
               Image(
                   modifier = Modifier
                       .size(32.dp)
                       .clip(RoundedCornerShape(16.dp))
                       .background(MaterialTheme.colorScheme.secondary)
                       .align(Alignment.TopEnd)
                       .clickable { onClose(tab) },
                   painter = painterResource(id = R.drawable.twotone_highlight_off_24),
                   contentDescription = stringResource(id = R.string.remove_tab),
                   colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSecondary)
               )
           }
        }
    }
}