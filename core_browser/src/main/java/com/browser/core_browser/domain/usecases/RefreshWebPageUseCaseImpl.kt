package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.RedBrowserTab
import com.browser.core_browser.domain.repository.RedBrowserRepository

internal class RefreshWebPageUseCaseImpl(private val repository: RedBrowserRepository):RefreshWebPageUseCase {
    override fun invoke(tab: RedBrowserTab) {
        repository.refreshWebPage(tab)
    }
}