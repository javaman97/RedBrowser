package com.browser.red.presentation.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.browser.core_browser.domain.model.RedBrowserTab
import androidx.compose.runtime.key
import com.browser.red.domain.utils.WebUtils

import com.browser.red.presentation.viewmodel.MainActivityViewModel
import timber.log.Timber

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    tab: RedBrowserTab?
) {
    if(tab == null) return
    if (tab.url == WebUtils.DEFAULT_URL) {
        HomeDefaultScreen()
    } else {
        AndroidView(
            factory = { tab.webView },
            update = { webView ->
                tab.webView = webView
            },
            modifier = Modifier
                .fillMaxSize()
                .then(modifier),
        )
    }
}
