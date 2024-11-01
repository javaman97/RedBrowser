package com.browser.core_browser.data.repository

import android.graphics.Bitmap
import android.graphics.Canvas
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.view.drawToBitmap
import com.browser.core_browser.domain.model.RedBrowserTab
import com.browser.core_browser.domain.repository.RedBrowserRepository

/**
 * Implementation of [RedBrowserRepository] for managing browser tabs and [WebView] settings.
 *
 * This class provides methods to configure web views, load URLs, clear data,
 * set custom clients, and handle navigation events in [RedBrowserTab] instances.
 * It enables JavaScript, manages caching behavior, and customizes client settings.
 */
class RedBrowserRepositoryImpl : RedBrowserRepository {

    /**
     * Configures [WebView] settings for a given [RedBrowserTab].
     *
     * Enables JavaScript, disables caching, and clears history and cache for the web view.
     *
     * @param tab The [RedBrowserTab] containing the [WebView] to configure.
     * @return The configured [RedBrowserTab] instance.
     */
    override fun configureWebView(tab: RedBrowserTab): RedBrowserTab {
        tab.webView.apply {
            settings.javaScriptEnabled = true
            settings.cacheMode = WebSettings.LOAD_NO_CACHE
            clearHistory()
            clearCache(true)
        }
        return tab
    }

    /**
     * Loads the specified URL in the [WebView] of the provided [RedBrowserTab].
     *
     * @param tab The [RedBrowserTab] containing the [WebView] where the URL will be loaded.
     */
    override fun loadUrl(tab: RedBrowserTab) {
        tab.webView.loadUrl(tab.url)
    }

    /**
     * Retrieves the [WebSettings] for the [WebView] of the specified [RedBrowserTab].
     *
     * @param tab The [RedBrowserTab] containing the [WebView] whose settings are retrieved.
     * @return The [WebSettings] of the web view.
     */
    override fun getWebViewSettings(tab: RedBrowserTab): WebSettings {
        return tab.webView.settings
    }

    /**
     * Clears browsing data in the [WebView] of the specified [RedBrowserTab].
     *
     * Clears cache, history, and form data, providing a clean state for the next browsing session.
     *
     * @param tab The [RedBrowserTab] containing the [WebView] to clear data from.
     */
    override fun clearWebViewData(tab: RedBrowserTab) {
        tab.webView.apply {
            clearCache(true)
            clearHistory()
            clearFormData()
        }
    }

    /**
     * Sets a custom [WebViewClient] to handle web content loading events for the [WebView] in the specified [RedBrowserTab].
     *
     * Assigns the provided client to the web view and updates the tab’s [WebViewClient] property.
     *
     * @param tab The [RedBrowserTab] containing the [WebView] where the client is set.
     * @param client The [WebViewClient] for handling web content loading events.
     */
    override fun setWebViewClient(tab: RedBrowserTab, client: WebViewClient) {
        tab.webView.webViewClient = client
        tab.webViewClient = client
    }

    /**
     * Sets a custom [WebChromeClient] for managing UI events in the [WebView] of the specified [RedBrowserTab].
     *
     * Updates the tab’s [WebChromeClient] property to the provided client for handling UI-related events.
     *
     * @param tab The [RedBrowserTab] containing the [WebView] where the client is set.
     * @param client The [WebChromeClient] for managing UI events.
     */
    override fun setWebChromeClient(tab: RedBrowserTab, client: WebChromeClient) {
        tab.webView.webChromeClient = client
        tab.webChromeClient = client
    }

    /**
     * Checks if the [WebView] in the specified [RedBrowserTab] can navigate back in its browsing history.
     *
     * @param tab The [RedBrowserTab] containing the [WebView] to check for back navigation.
     * @return `true` if the web view can navigate back; otherwise, `false`.
     */
    override fun canGoBack(tab: RedBrowserTab): Boolean {
        return tab.webView.canGoBack()
    }

    /**
     * Navigates back in the browsing history of the [WebView] in the specified [RedBrowserTab].
     *
     * @param tab The [RedBrowserTab] containing the [WebView] to navigate back.
     */
    override fun goBack(tab: RedBrowserTab) {
        tab.webView.goBack()
    }

    /**
     * Checks if the [WebView] in the specified [RedBrowserTab] can navigate forward in its browsing history.
     *
     * @param tab The [RedBrowserTab] containing the [WebView] to check for forward navigation.
     * @return `true` if the web view can navigate forward; otherwise, `false`.
     */
    override fun canGoForward(tab: RedBrowserTab): Boolean {
        return tab.webView.canGoForward()
    }

    /**
     * Navigates forward in the browsing history of the [WebView] in the specified [RedBrowserTab].
     *
     * @param tab The [RedBrowserTab] containing the [WebView] to navigate forward.
     */
    override fun goForward(tab: RedBrowserTab) {
        tab.webView.goForward()
    }

    override fun refreshWebPage(tab: RedBrowserTab) {
        tab.webView.reload()
    }

}
