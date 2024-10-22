package com.browser.red.presentation.ui.components

import android.webkit.WebView
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.browser.core_browser.domain.model.RedBrowserTab
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
    onClick:()->Unit={}
    ){
    val sizeDp = DpSize(width = 120.dp, height = 150.dp)
    Card (elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .padding(Dimensions.MediumPadding)
            .size(sizeDp)


    ) {
        Box(
            modifier = Modifier
                .clickable { onClick() }
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    imageVector = Icons.Default.Face,
                    contentDescription = "testing"
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
        }
    }
}