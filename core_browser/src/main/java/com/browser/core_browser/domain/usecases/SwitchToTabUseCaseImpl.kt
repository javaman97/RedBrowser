package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.manager.TabManager
import com.browser.core_browser.domain.model.RedBrowserTab

/**
 * Implementation of [SwitchToTabUseCase] that utilizes the [TabManager] to switch tabs.
 *
 * @property tabManager The [TabManager] instance to manage tab operations.
 */
internal class SwitchToTabUseCaseImpl(private val tabManager: TabManager) : SwitchToTabUseCase {
    /**
     * Switches to the tab at the specified [index].
     *
     * @param index The index of the tab to switch to.
     * @return The [RedBrowserTab] that is now the current tab, or null if the index is out of bounds.
     */
    override fun invoke(index: Int): RedBrowserTab? {
        return tabManager.switchToTab(index)
    }
}
