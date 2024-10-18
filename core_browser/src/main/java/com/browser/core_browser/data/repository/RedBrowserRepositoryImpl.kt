package com.browser.core_browser.data.repository

import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import com.browser.core_browser.domain.model.RedBrowserTab
import com.browser.core_browser.domain.repository.RedBrowserRepository

/**
 * Implementation of [RedBrowserRepository] for managing browser tabs and [WebView] settings.
 *
 * This class provides functionality to configure web views, load URLs,
 * and manage web view data for instances of [RedBrowserTab].
 *
 * It enables JavaScript, manages caching behavior, and provides methods to
 * clear data, set clients, and retrieve web view settings.
 */
class RedBrowserRepositoryImpl : RedBrowserRepository {

    /**
     * Configures the given [RedBrowserTab]'s [WebView] settings.
     *
     * This method enables JavaScript and sets the cache mode to no cache.
     * It also clears the history and cache for the [WebView].
     *
     * @param tab The [RedBrowserTab] to configure.
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
     * Loads the specified URL in the given [RedBrowserTab].
     *
     * @param tab The [RedBrowserTab] in which to load the URL.
     */
    override fun loadUrl(tab: RedBrowserTab) {
        tab.webView.loadUrl(tab.url)
    }

    /**
     * Retrieves the [WebSettings] for the specified [RedBrowserTab]'s [WebView].
     *
     * @param tab The [RedBrowserTab] whose settings are to be retrieved.
     * @return The [WebSettings] of the [WebView].
     */
    override fun getWebViewSettings(tab: RedBrowserTab): WebSettings {
        return tab.webView.settings
    }

    /**
     * Clears the data of the given [RedBrowserTab]'s [WebView].
     *
     * This method clears the web view's cache, history, and form data.
     *
     * @param tab The [RedBrowserTab] whose data will be cleared.
     */
    override fun clearWebViewData(tab: RedBrowserTab) {
        tab.webView.apply {
            clearCache(true)
            clearHistory()
            clearFormData()
        }
    }

    /**
     * Sets a custom [WebViewClient] for the specified [RedBrowserTab]'s [WebView].
     *
     * This method assigns the provided client to the web view and updates
     * the corresponding property in the [RedBrowserTab].
     *
     * @param tab The [RedBrowserTab] for which the [WebViewClient] will be set.
     * @param client The [WebViewClient] to be associated with the specified tab.
     */
    override fun setWebViewClient(tab: RedBrowserTab, client: WebViewClient) {
        tab.webView.webViewClient = client
        tab.webViewClient = client
    }

    /**
     * Sets a custom [WebChromeClient] for the specified [RedBrowserTab]'s [WebView].
     *
     * This method assigns the provided client to the web view and updates
     * the corresponding property in the [RedBrowserTab].
     *
     * @param tab The [RedBrowserTab] for which the [WebChromeClient] will be set.
     * @param client The [WebChromeClient] to be associated with the specified tab.
     */
    override fun setWebChromeClient(tab: RedBrowserTab, client: WebChromeClient) {
        tab.webView.webChromeClient = client
        tab.webChromeClient = client
    }
}
