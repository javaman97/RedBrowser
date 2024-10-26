package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.RedBrowserTab
import com.browser.core_browser.domain.repository.RedBrowserRepository

/**
 * Implementation of [CanGoForwardUseCase] for checking forward navigation capability
 * within a browser tab's history.
 *
 * This class provides the functionality to determine if the specified [RedBrowserTab]
 * can move forward in its browsing history by interacting with the [RedBrowserRepository].
 *
 * @property repository The [RedBrowserRepository] to check the forward navigation capability.
 */
internal class CanGoForwardUseCaseImpl(
    private val repository: RedBrowserRepository
) : CanGoForwardUseCase {

    /**
     * Checks if the specified [tab] can navigate forward.
     *
     * @param tab The [RedBrowserTab] for which forward navigation is to be checked.
     * @return `true` if forward navigation is possible; `false` otherwise.
     */
    override fun invoke(tab: RedBrowserTab): Boolean {
        return repository.canGoForward(tab)
    }
}
