package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.manager.TabManager
import com.browser.core_browser.domain.model.RedBrowserTab

/**
 * Implementation of the [GetCurrentTabUseCase] interface.
 *
 * Retrieves the currently active tab from the provided [TabManager].
 *
 * @param tabManager The [TabManager] instance used to access the tab data.
 */
internal class GetCurrentTabUseCaseImpl(private val tabManager: TabManager) : GetCurrentTabUseCase {

    /**
     * Invokes the use case to get the currently active [RedBrowserTab].
     *
     * @return The currently active [RedBrowserTab], or null if no tabs are open.
     */
    override fun invoke(): RedBrowserTab? {
        return tabManager.getCurrentTab()
    }
}
