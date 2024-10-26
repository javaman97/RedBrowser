package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.ChromeClientData
import com.browser.core_browser.domain.model.RedBrowserTab
import kotlinx.coroutines.flow.StateFlow

interface ObserveChromeClientData {
    operator fun invoke(tab:RedBrowserTab):StateFlow<ChromeClientData>?
}