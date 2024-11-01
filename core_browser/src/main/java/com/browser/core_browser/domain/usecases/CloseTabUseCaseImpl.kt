package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.manager.TabManager
import com.browser.core_browser.domain.model.RedBrowserTab

/**
 * Implementation of the [CloseTabUseCase] interface, responsible for closing a specified browser tab.
 *
 * This class interacts with the [TabManager] to handle the closure of a browser tab, removing it
 * from active management and freeing associated resources. It provides the core functionality for
 * managing tab lifecycle within the browser.
 *
 * @property tabManager The [TabManager] instance used to manage and close browser tabs.
 */
internal class CloseTabUseCaseImpl(private val tabManager: TabManager) : CloseTabUseCase {

    /**
     * Closes the specified browser tab.
     *
     * This function overrides the `invoke` operator function in the [CloseTabUseCase] interface.
     * It delegates the tab closing operation to the [TabManager], which performs the necessary
     * steps to clean up and remove the tab from active sessions.
     *
     * @param tab The [RedBrowserTab] instance to be closed.
     */
    override fun invoke(tab: RedBrowserTab) {
        tabManager.closeTab(tab)
    }
}
