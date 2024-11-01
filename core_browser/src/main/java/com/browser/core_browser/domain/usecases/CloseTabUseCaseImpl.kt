package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.manager.TabManager
import com.browser.core_browser.domain.model.RedBrowserTab

internal class CloseTabUseCaseImpl(private val tabManager: TabManager):CloseTabUseCase {
    override fun invoke(tab: RedBrowserTab) {
        tabManager.closeTab(tab)
    }
}