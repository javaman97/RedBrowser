package com.browser.core_browser.domain.model

import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import java.util.UUID

/**
 * Represents a single tab in the RedBrowser.
 *
 * Each tab is uniquely identified by its [id], contains a [webView] to render web content,
 * and holds the current [url] being displayed. The tab can also have custom
 * instances of [WebViewClient] and [WebChromeClient] for handling page
 * loading events and UI changes, respectively.
 *
 * @property id Unique identifier for the tab. A new UUID is generated by default when a tab is created.
 * @property webView The WebView instance responsible for loading and displaying web content in this tab.
 * @property url The current URL loaded in the WebView. Can be updated as the user navigates.
 * @property webViewClient Optional custom [WebViewClient] for managing page load events in this tab.
 * @property webChromeClient Optional custom [WebChromeClient] for handling browser-specific UI changes.
 */
data class RedBrowserTab(
    val id: UUID = UUID.randomUUID(),
    var webView: WebView,
    var url: String,
    var webViewClient: WebViewClient? = null,
    var webChromeClient: WebChromeClient? = null
)
