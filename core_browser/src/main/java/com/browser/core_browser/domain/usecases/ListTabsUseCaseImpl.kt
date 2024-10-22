package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.manager.TabManager
import com.browser.core_browser.domain.model.RedBrowserTab

internal class ListTabsUseCaseImpl(private val tabManager: TabManager): ListTabsUseCase {
    override fun invoke(): List<RedBrowserTab> {
        return tabManager.listTabs()
    }
}