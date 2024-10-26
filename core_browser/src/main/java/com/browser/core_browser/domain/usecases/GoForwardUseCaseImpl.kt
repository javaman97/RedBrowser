package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.RedBrowserTab
import com.browser.core_browser.domain.repository.RedBrowserRepository

/**
 * Implementation of [GoForwardUseCase] for navigating forward in a browser tab's history.
 *
 * This class provides functionality to advance within the browsing history
 * of the specified [RedBrowserTab] by invoking the [repository]'s go forward method.
 *
 * @property repository The [RedBrowserRepository] that provides navigation capabilities.
 */
internal class GoForwardUseCaseImpl(private val repository: RedBrowserRepository) : GoForwardUseCase {

    /**
     * Navigates forward in the specified [tab]'s browsing history.
     *
     * @param tab The [RedBrowserTab] in which to perform forward navigation.
     */
    override fun invoke(tab: RedBrowserTab) {
        repository.goForward(tab)
    }
}
