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
import androidx.compose.ui.focus.onFocusChanged
import com.browser.red.domain.utils.WebUtils

import com.browser.red.presentation.viewmodel.MainActivityViewModel
import timber.log.Timber

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    mainActivityViewModel: MainActivityViewModel
) {
    val tab = mainActivityViewModel.mCurrentTab ?: return
    if (tab.url == WebUtils.DEFAULT_URL) {
        HomeDefaultScreen{
            if(it.url != null){
                val newTab = tab.copy(url = it.url)
                mainActivityViewModel.loadUrl(newTab)
            }
        }
    } else {
        AndroidView(
            factory = { tab.webView },
            update = { webView ->
                tab.webView = webView
            },
            modifier = Modifier
                .fillMaxSize()
                .onFocusChanged {
                    if(it.hasFocus){
                        mainActivityViewModel.showAddressBarEditable = false
                    }
                }
                .then(modifier),
        )
    }
}
