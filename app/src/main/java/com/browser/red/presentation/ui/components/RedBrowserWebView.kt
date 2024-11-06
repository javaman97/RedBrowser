package com.browser.red.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.viewinterop.AndroidView
import com.browser.core_browser.domain.model.RedBrowserTab

@Composable
 fun RedBrowserWebView(
    tab: RedBrowserTab,
    modifier: Modifier,
    onFocusChanged:(FocusState)-> Unit = {}
) {
    AndroidView(
        factory = { tab.webView },
        update = { webView ->
            tab.webView = webView
        },
        modifier = Modifier
            .fillMaxSize()
            .onFocusChanged {
               onFocusChanged(it)
            }
            .then(modifier),
    )
}