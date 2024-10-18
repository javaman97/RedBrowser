package com.browser.core_browser.domain.model

/**
 * Data class representing the state of a WebView's ChromeClient.
 *
 * @property progress The current loading progress of the WebView, ranging from 0 to 100.
 * @property title The title of the currently loaded webpage, or null if not available.
 */
data class ChromeClientData(
    var progress: Int,
    var title: String?
)
