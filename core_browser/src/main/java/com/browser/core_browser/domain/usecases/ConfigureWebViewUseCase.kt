package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.RedBrowserTab

/**
 * Use case interface for configuring a WebView in a specific browser tab.
 *
 * This interface defines the method required to configure the WebView settings in a [RedBrowserTab].
 */
interface ConfigureWebViewUseCase {
    /**
     * Configures the WebView associated with the specified [RedBrowserTab].
     *
     * @param tab The [RedBrowserTab] to be configured.
     * @return The configured [RedBrowserTab].
     */
    operator fun invoke(tab: RedBrowserTab): RedBrowserTab
}
