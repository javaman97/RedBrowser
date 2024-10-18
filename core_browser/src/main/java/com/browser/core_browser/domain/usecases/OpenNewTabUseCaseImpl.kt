package com.browser.core_browser.domain.usecases

import android.webkit.WebView
import com.browser.core_browser.domain.manager.TabManager
import com.browser.core_browser.domain.model.RedBrowserTab

/**
 * Implementation of [OpenNewTabUseCase] for opening a new tab in the RedBrowser.
 *
 * This class uses a [TabManager] to manage the opening of new tabs.
 *
 * @param tabManager The [TabManager] used to handle tab operations.
 */
internal class OpenNewTabUseCaseImpl(private val tabManager: TabManager) : OpenNewTabUseCase {

    /**
     * Opens a new tab using the specified [WebView] and URL.
     *
     * @param webView The [WebView] instance in which to open the new tab.
     * @param url The URL to load in the new tab.
     *  @return [RedBrowserTab] is returned as newly created tab
     */
    override operator fun invoke(webView: WebView, url: String):RedBrowserTab {
        // Optionally, add error handling for URL validation
        if (url.isEmpty()) {
            throw IllegalArgumentException("URL cannot be empty")
        }

        return tabManager.openNewTab(webView, url)
    }
}
