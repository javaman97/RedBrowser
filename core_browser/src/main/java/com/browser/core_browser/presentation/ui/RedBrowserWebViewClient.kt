package com.browser.core_browser.presentation.ui

import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

/**
 * Custom WebViewClient for managing page load and request interception.
 */
class RedBrowserWebViewClient : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        // Handle URL loading logic, such as intercepting or modifying the request.
        return super.shouldOverrideUrlLoading(view, request)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        // Notify the UI when the page is fully loaded, like hiding the progress bar.
    }
}
