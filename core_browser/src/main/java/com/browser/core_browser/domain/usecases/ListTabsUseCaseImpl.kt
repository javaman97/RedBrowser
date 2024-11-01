package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.manager.TabManager
import com.browser.core_browser.domain.model.RedBrowserTab

/**
 * Implementation of the [ListTabsUseCase] interface, responsible for retrieving a list of active browser tabs.
 *
 * This class interacts with the [TabManager] to fetch all currently open tabs, providing
 * a complete overview of the active tabs in the browser session. It supports tab management
 * by returning a list of [RedBrowserTab] instances representing each active tab.
 *
 * @property tabManager The [TabManager] instance used to manage and retrieve active browser tabs.
 */
internal class ListTabsUseCaseImpl(private val tabManager: TabManager) : ListTabsUseCase {

    /**
     * Retrieves a list of all active browser tabs.
     *
     * This function overrides the `invoke` operator function in the [ListTabsUseCase] interface.
     * It delegates the task to [TabManager] to obtain a list of [RedBrowserTab] instances,
     * which can be used for managing or displaying open tabs.
     *
     * @return A list of [RedBrowserTab] instances representing the currently active tabs.
     */
    override fun invoke(): List<RedBrowserTab> {
        return tabManager.listTabs()
    }
}
