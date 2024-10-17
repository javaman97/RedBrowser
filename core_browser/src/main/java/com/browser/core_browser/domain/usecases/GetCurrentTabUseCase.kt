package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.RedBrowserTab

/**
 * Defines the contract for retrieving the currently active tab in the RedBrowser.
 */
interface GetCurrentTabUseCase {

    /**
     * Invokes the use case to retrieve the currently active [RedBrowserTab].
     *
     * @return The currently active [RedBrowserTab], or null if no tabs are open.
     */
    operator fun invoke(): RedBrowserTab?
}
