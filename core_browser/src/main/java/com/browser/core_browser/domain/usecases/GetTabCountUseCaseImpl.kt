package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.manager.TabManager

/**
 * Implementation of the [GetTabCountUseCase] for retrieving the current count of browser tabs.
 *
 * This use case interacts with the [TabManager] to determine the number of currently open tabs.
 *
 * @property tabManager The manager responsible for handling browser tabs.
 */
internal class GetTabCountUseCaseImpl(private val tabManager: TabManager) : GetTabCountUseCase {

    /**
     * Returns the current number of open tabs by delegating to the [TabManager].
     *
     * @return The total number of open tabs managed by [TabManager].
     */
    override fun invoke(): Int {
        return tabManager.getTabCount()
    }
}
