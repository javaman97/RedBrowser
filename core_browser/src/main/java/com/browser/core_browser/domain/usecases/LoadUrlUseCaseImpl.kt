package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.RedBrowserTab
import com.browser.core_browser.domain.repository.RedBrowserRepository

/**
 * Implementation of [LoadUrlUseCase] for loading a URL in a browser tab.
 *
 * This class uses a [RedBrowserRepository] to perform the URL loading operation.
 *
 * @param repository The [RedBrowserRepository] used to load the URL in the tab.
 */
internal class LoadUrlUseCaseImpl(private val repository: RedBrowserRepository) : LoadUrlUseCase {

    /**
     * Loads the URL associated with the specified [RedBrowserTab].
     *
     * @param tab The [RedBrowserTab] in which to load the URL.
     */
    override operator fun invoke(tab: RedBrowserTab) {
        // Optionally, add error handling or validation here
        if (tab.url.isEmpty()) {
            throw IllegalArgumentException("Tab URL cannot be empty")
        }

        repository.loadUrl(tab)
    }
}
