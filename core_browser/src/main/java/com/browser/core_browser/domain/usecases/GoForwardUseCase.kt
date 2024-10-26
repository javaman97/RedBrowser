package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.RedBrowserTab

/**
 * Interface for a use case that navigates forward within a browser tab's history.
 *
 * Implementations of this interface provide functionality to move forward in
 * the browsing history of a specified [RedBrowserTab].
 */
interface GoForwardUseCase {

    /**
     * Navigates forward within the specified [tab]'s browsing history.
     *
     * @param tab The [RedBrowserTab] in which to perform forward navigation.
     */
    operator fun invoke(tab: RedBrowserTab)
}
