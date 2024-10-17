package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.RedBrowserTab

/**
 * Use case interface for loading a URL in a specific browser tab.
 *
 * This interface defines the method required to load a URL in a [RedBrowserTab].
 */
interface LoadUrlUseCase {
    /**
     * Loads the URL associated with the specified [RedBrowserTab].
     *
     * @param tab The [RedBrowserTab] in which to load the URL.
     */
    operator fun invoke(tab: RedBrowserTab)
}
