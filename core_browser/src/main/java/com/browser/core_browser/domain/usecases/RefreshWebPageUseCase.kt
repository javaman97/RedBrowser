package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.RedBrowserTab

/**
 * A use case interface for refreshing a specified browser tab.
 *
 * This interface defines a contract for reloading the content of a browser tab, allowing
 * users to fetch the latest data displayed in the tab.
 */
interface RefreshWebPageUseCase {

    /**
     * Refreshes the content of the specified browser tab.
     *
     * This operator function is designed to be invoked like a function, making it simple
     * to refresh a tab by passing in the relevant [RedBrowserTab] instance. Implementations
     * of this use case handle the reloading of the webpage to ensure that the most recent
     * content is displayed to the user.
     *
     * @param tab The [RedBrowserTab] instance to be refreshed.
     */
    operator fun invoke(tab: RedBrowserTab)
}
