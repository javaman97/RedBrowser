package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.RedBrowserTab

/**
 * Use case for checking if a browser tab can navigate backward in its history.
 *
 * This interface provides an operator function that, when implemented, returns
 * whether the given [RedBrowserTab] has any previous pages to navigate to.
 */
interface CanGoBackUseCase {

    /**
     * Checks if the specified [tab] can navigate back in its history.
     *
     * @param tab The [RedBrowserTab] to check for backward navigation capability.
     * @return `true` if the tab can navigate back; `false` otherwise.
     */
    operator fun invoke(tab: RedBrowserTab): Boolean
}
