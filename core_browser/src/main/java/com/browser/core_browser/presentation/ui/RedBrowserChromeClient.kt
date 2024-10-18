package com.browser.core_browser.presentation.ui

import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.compose.runtime.State
import com.browser.core_browser.domain.model.ChromeClientData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Custom WebChromeClient for handling browser-specific UI changes,
 * such as managing progress bar and title updates for WebView.
 */
class RedBrowserChromeClient : WebChromeClient() {
    private var _data = MutableStateFlow(ChromeClientData(0, ""))
    val data = _data.asStateFlow()

    override fun onProgressChanged(view: WebView?, newProgress: Int) {
        // Clamp the progress between 0 and 100
        _data.value = _data.value.copy(progress = newProgress.coerceIn(0, 100))
    }

    override fun onReceivedTitle(view: WebView?, title: String?) {
        _data.value = _data.value.copy(title = title)
    }
}
