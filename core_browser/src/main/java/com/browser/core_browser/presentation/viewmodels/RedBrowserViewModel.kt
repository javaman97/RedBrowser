package com.browser.core_browser.presentation.viewmodels

import android.webkit.WebView
import androidx.lifecycle.ViewModel
import com.browser.core_browser.domain.model.RedBrowserTab
import com.browser.core_browser.domain.usecases.ConfigureWebViewUseCase
import com.browser.core_browser.domain.usecases.GetCurrentTabUseCase
import com.browser.core_browser.domain.usecases.LoadUrlUseCase
import com.browser.core_browser.domain.usecases.OpenNewTabUseCase
import com.browser.core_browser.presentation.ui.RedBrowserWebViewClient
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * ViewModel for managing the UI-related data in the RedBrowser.
 *
 * This ViewModel communicates with use cases to open new tabs, load URLs,
 * configure WebView settings, and retrieve the current active tab.
 *
 * @param openNewTabUseCase Use case for opening a new browser tab.
 * @param loadUrlUseCase Use case for loading a URL in the current tab.
 * @param configureWebViewUseCase Use case for configuring the WebView for a tab.
 * @param getCurrentTabUseCase Use case for retrieving the currently active tab.
 */
@HiltViewModel
class RedBrowserViewModel @Inject constructor(
    val openNewTabUseCase: OpenNewTabUseCase,
    val loadUrlUseCase: LoadUrlUseCase,
    val configureWebViewUseCase: ConfigureWebViewUseCase,
    val getCurrentTabUseCase: GetCurrentTabUseCase
) : ViewModel() {

    /**
     * Opens a new tab with the specified [webView] and [url].
     *
     * @param webView The WebView instance to be associated with the new tab.
     * @param url The URL to load in the new tab.
     * @return The newly created [RedBrowserTab].
     */
    fun openNewTab(webView: WebView, url: String): RedBrowserTab {
        return openNewTabUseCase(webView, url)
    }

    /**
     * Configures the WebView settings for the specified [tab].
     *
     * @param tab The [RedBrowserTab] to configure.
     */
    fun configureWebView(tab: RedBrowserTab) {
        configureWebViewUseCase(tab)
    }

    /**
     * Loads the URL for the specified [tab].
     *
     * @param tab The [RedBrowserTab] for which to load the URL.
     */
    fun loadUrl(tab: RedBrowserTab) {
        loadUrlUseCase(tab)
    }

    /**
     * Retrieves the currently active tab.
     *
     * @return The currently active [RedBrowserTab], or null if no tabs are open.
     */
    fun getCurrentTab(): RedBrowserTab? {
        return getCurrentTabUseCase()
    }
}
