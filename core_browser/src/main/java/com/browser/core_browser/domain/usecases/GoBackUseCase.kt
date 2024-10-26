package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.RedBrowserTab

/**
 * Interface for navigating back within a browser tab's history.
 *
 * This interface provides the contract for implementing back navigation
 * functionality for instances of [RedBrowserTab].
 */
interface GoBackUseCase {

    /**
     * Navigates back within the specified [tab]'s browsing history.
     *
     * @param tab The [RedBrowserTab] for which to perform back navigation.
     */
    operator fun invoke(tab: RedBrowserTab)
}
