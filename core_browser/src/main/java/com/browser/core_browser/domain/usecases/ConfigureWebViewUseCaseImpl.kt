package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.RedBrowserTab
import com.browser.core_browser.domain.repository.RedBrowserRepository

/**
 * Implementation of [ConfigureWebViewUseCase] for configuring a WebView in a browser tab.
 *
 * This class uses a [RedBrowserRepository] to perform the configuration operation.
 *
 * @param repository The [RedBrowserRepository] used to configure the WebView in the tab.
 */
internal class ConfigureWebViewUseCaseImpl(private val repository: RedBrowserRepository) :
    ConfigureWebViewUseCase {

    /**
     * Configures the WebView associated with the specified [RedBrowserTab].
     *
     * @param tab The [RedBrowserTab] to be configured.
     * @return The configured [RedBrowserTab].
     */
    override operator fun invoke(tab: RedBrowserTab): RedBrowserTab {
        // Optionally, add error handling or validation here
        if (tab.webView == null) {
            throw IllegalArgumentException("Tab's WebView cannot be null")
        }

        return repository.configureWebView(tab)
    }
}
