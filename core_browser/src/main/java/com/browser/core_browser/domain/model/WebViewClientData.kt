package com.browser.core_browser.domain.model

import android.graphics.Bitmap

/**
 * Data class representing the state of the WebViewClient.
 *
 * @property isPageFinished Indicates whether the page loading is finished.
 * @property favIcon The favicon of the currently loaded page, if available.
 * @property url The URL of the currently loaded page.
 */
data class WebViewClientData(
    var isPageFinished: Boolean = false,
    var favIcon: Bitmap? = null,
    var url: String? = null
)

