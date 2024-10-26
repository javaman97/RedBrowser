package com.browser.core_browser.domain.model

import android.graphics.Bitmap

/**
 * Data class representing the state and information of a [WebViewClient] during page loading.
 *
 * @property onPageStarted Indicates whether the page loading has started.
 * @property onPageFinished Indicates whether the page loading is complete.
 * @property favIcon The favicon of the currently loaded page, if available.
 * @property url The URL of the currently loaded page.
 */
data class WebViewClientData(
    var onPageStarted: Boolean = false,
    var onPageFinished: Boolean = true,
    var favIcon: Bitmap? = null,
    var url: String? = null
)

