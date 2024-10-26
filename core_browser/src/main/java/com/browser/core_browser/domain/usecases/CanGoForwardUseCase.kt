package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.RedBrowserTab

/**
 * Use case for checking if a browser tab can navigate forward in its browsing history.
 *
 * This interface provides a method to determine if forward navigation is possible for
 * a specified [RedBrowserTab].
 */
interface CanGoForwardUseCase {

    /**
     * Determines if the specified [tab] can navigate forward in its history.
     *
     * @param tab The [RedBrowserTab] for which forward navigation is checked.
     * @return `true` if the tab can navigate forward; `false` otherwise.
     */
    operator fun invoke(tab: RedBrowserTab): Boolean
}
