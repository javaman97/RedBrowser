package com.browser.core_browser.domain.repository

import android.webkit.WebSettings
import android.webkit.WebView
import com.browser.core_browser.domain.model.RedBrowserTab


/**
 * Repository interface for managing browser tabs and their associated [WebView] settings.
 *
 * This repository provides methods for configuring web views, loading URLs,
 * retrieving web view settings, and clearing web view data.
 */
interface RedBrowserRepository {

    /**
     * Configures the given [RedBrowserTab]'s [WebView] settings.
     *
     * The method enables JavaScript and disables caching by setting the cache mode to
     * [WebSettings.LOAD_NO_CACHE]. It also clears the web view's history and cache.
     *
     * @param tab The [RedBrowserTab] that contains the [WebView] to be configured.
     * @return The updated [RedBrowserTab] with the configured [WebView].
     */
    fun configureWebView(tab: RedBrowserTab): RedBrowserTab

    /**
     * Loads the specified URL into the given [RedBrowserTab]'s [WebView].
     *
     * @param tab The [RedBrowserTab] that contains the [WebView] in which the URL will be loaded.
     */
    fun loadUrl(tab: RedBrowserTab)

    /**
     * Retrieves the [WebSettings] of the [WebView] from the given [RedBrowserTab].
     *
     * The [WebSettings] can be used to further customize the behavior of the web view,
     * such as controlling JavaScript, zoom controls, caching, and more.
     *
     * @param tab The [RedBrowserTab] that contains the [WebView] whose settings will be retrieved.
     * @return The [WebSettings] of the specified [WebView].
     */
    fun getWebViewSettings(tab: RedBrowserTab): WebSettings

    /**
     * Clears all data from the [WebView] in the given [RedBrowserTab].
     *
     * This method clears the web view's cache, history, and form data, ensuring a clean slate
     * for the next browsing session.
     *
     * @param tab The [RedBrowserTab] that contains the [WebView] whose data will be cleared.
     */
    fun clearWebViewData(tab: RedBrowserTab)
}
