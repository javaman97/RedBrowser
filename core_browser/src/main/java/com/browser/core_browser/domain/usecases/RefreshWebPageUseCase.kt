package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.RedBrowserTab

interface RefreshWebPageUseCase {
    operator fun invoke(tab:RedBrowserTab)
}