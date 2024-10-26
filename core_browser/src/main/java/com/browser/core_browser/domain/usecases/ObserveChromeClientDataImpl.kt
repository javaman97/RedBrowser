package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.ChromeClientData
import com.browser.core_browser.domain.model.RedBrowserTab
import com.browser.core_browser.presentation.ui.RedBrowserChromeClient
import kotlinx.coroutines.flow.StateFlow

internal class ObserveChromeClientDataImpl:ObserveChromeClientData {
    override fun invoke(tab:RedBrowserTab): StateFlow<ChromeClientData>? {
        val client = tab.webChromeClient
        return if(client != null && client is RedBrowserChromeClient){
            client.data
        } else {
            null
        }
    }
}