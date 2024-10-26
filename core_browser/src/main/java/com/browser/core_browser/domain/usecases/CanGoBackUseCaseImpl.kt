package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.RedBrowserTab
import com.browser.core_browser.domain.repository.RedBrowserRepository

/**
 * Implementation of [CanGoBackUseCase] that checks if a browser tab
 * can navigate backward in its browsing history.
 *
 * This class uses [RedBrowserRepository] to determine if backward
 * navigation is available for the specified [RedBrowserTab].
 *
 * @param repository The [RedBrowserRepository] used to check the navigation capability.
 */
internal class CanGoBackUseCaseImpl(
    private val repository: RedBrowserRepository
) : CanGoBackUseCase {

    /**
     * Determines if the specified [tab] can navigate back in its history.
     *
     * @param tab The [RedBrowserTab] for which backward navigation is checked.
     * @return `true` if the tab can navigate back; `false` otherwise.
     */
    override fun invoke(tab: RedBrowserTab): Boolean {
        return repository.canGoBack(tab)
    }
}
