package com.browser.core_browser.presentation.ui

import android.graphics.Bitmap
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.browser.core_browser.Utils.captureImage
import com.browser.core_browser.domain.model.WebViewClientData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Custom WebViewClient for managing page load and request interception.
 *
 * This client handles updates to the WebViewClientData based on
 * the loading state of pages and can be extended to customize
 * URL loading behavior.
 */
class RedBrowserWebViewClient : WebViewClient() {
    private val _data = MutableStateFlow(WebViewClientData())
    val data = _data.asStateFlow()

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        // Customize URL loading behavior here if needed
        return super.shouldOverrideUrlLoading(view, request)
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        _data.value = _data.value.copy(
            onPageStarted = true,
            onPageFinished = false,
            favIcon = favicon,
            url = url
        )
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        CoroutineScope(Dispatchers.IO).launch{
            val thumbnail = view?.captureImage()
            _data.value = _data.value.copy(
                onPageStarted = false,
                onPageFinished = true,
                url = url,
                thumbnail = thumbnail
            )
        }
    }

}
