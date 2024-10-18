package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.RedBrowserTab
import com.browser.core_browser.domain.model.WebViewClientData
import kotlinx.coroutines.flow.StateFlow

/**
 * Interface for observing the [WebViewClientData] of a specific tab in the RedBrowser.
 *
 * This use case allows retrieving the current state of the [WebViewClientData],
 * which includes information such as the loading status, favicon, and URL of the
 * web page displayed in the specified tab.
 *
 * @param tab The [RedBrowserTab] for which to observe the [WebViewClientData].
 * @return A [StateFlow] emitting the current [WebViewClientData] for the specified tab,
 *         or null if the observation could not be established.
 */
interface ObserveWebViewClientDataUseCase {
    operator fun invoke(tab: RedBrowserTab): StateFlow<WebViewClientData>?
}
