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

import com.browser.red.presentation.viewmodel.MainActivityViewModel
import timber.log.Timber

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    tab: RedBrowserTab?
) {
    if (tab?.webView != null) {
        key(tab.id){
            AndroidView(
                factory = { tab.webView },
                update = { webView ->
                    // You can do updates here if needed, but avoid reloading URLs
                    // For example, you can update the visibility, settings, etc.
                },
                modifier = Modifier
                    .fillMaxSize()
                    .then(modifier),
            )
        }

    }
}
