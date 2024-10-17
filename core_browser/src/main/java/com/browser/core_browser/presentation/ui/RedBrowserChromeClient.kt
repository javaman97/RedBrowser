package com.browser.core_browser.presentation.ui

import android.webkit.WebChromeClient
import android.webkit.WebView

/**
 * Custom WebChromeClient for handling browser-specific UI changes,
 * such as managing progress bar and title updates for WebView.
 */
class RedBrowserChromeClient : WebChromeClient() {

    override fun onProgressChanged(view: WebView?, newProgress: Int) {
        // Update the progress bar or other UI components
    }

    override fun onReceivedTitle(view: WebView?, title: String?) {
        // Update the title in the toolbar or action bar
    }
}
