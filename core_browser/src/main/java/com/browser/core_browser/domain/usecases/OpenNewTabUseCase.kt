package com.browser.core_browser.domain.usecases

import android.webkit.WebView
import com.browser.core_browser.domain.model.RedBrowserTab

/**
 * Use case interface for opening a new tab in the RedBrowser.
 *
 * This interface defines the method required to open a new tab with a specified [WebView] and URL.
 */
interface OpenNewTabUseCase {
    /**
     * Opens a new tab using the specified [WebView] and URL.
     *
     * @param webView The [WebView] instance in which to open the new tab.
     * @param url The URL to load in the new tab.
     * @return [RedBrowserTab] is returned as newly created tab
     */
    operator fun invoke(webView: WebView, url: String):RedBrowserTab
}
