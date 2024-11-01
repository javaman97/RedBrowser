package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.RedBrowserTab

/**
 * A use case interface for listing all active browser tabs.
 *
 * This interface defines a contract for retrieving a list of currently open browser tabs,
 * enabling clients to access and manage the active tabs within a session.
 */
interface ListTabsUseCase {

    /**
     * Retrieves a list of all active browser tabs.
     *
     * This operator function allows for straightforward invocation using `invoke` syntax,
     * returning a list of [RedBrowserTab] instances that represent the tabs currently
     * open in the browser. It provides an overview of active tabs for management or display purposes.
     *
     * @return A list of [RedBrowserTab] instances representing the currently active tabs.
     */
    operator fun invoke(): List<RedBrowserTab>
}
