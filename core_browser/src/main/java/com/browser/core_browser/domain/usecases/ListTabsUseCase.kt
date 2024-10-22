package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.RedBrowserTab

interface ListTabsUseCase {
    operator fun invoke():List<RedBrowserTab>
}