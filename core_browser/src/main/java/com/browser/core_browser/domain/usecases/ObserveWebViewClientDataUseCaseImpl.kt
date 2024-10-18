package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.RedBrowserTab
import com.browser.core_browser.domain.model.WebViewClientData
import com.browser.core_browser.presentation.ui.RedBrowserWebViewClient
import kotlinx.coroutines.flow.StateFlow

/**
 * Implementation of [ObserveWebViewClientDataUseCase] for observing the [WebViewClientData]
 * of a specific [RedBrowserTab].
 *
 * This use case retrieves the current state of the [WebViewClientData] associated with the
 * specified tab by checking if its [webViewClient] is an instance of [RedBrowserWebViewClient].
 *
 * @param tab The [RedBrowserTab] for which to observe the [WebViewClientData].
 * @return A [StateFlow] emitting the current [WebViewClientData] for the specified tab,
 *         or null if the [webViewClient] is not an instance of [RedBrowserWebViewClient].
 */
internal class ObserveWebViewClientDataUseCaseImpl : ObserveWebViewClientDataUseCase {
    override fun invoke(tab: RedBrowserTab): StateFlow<WebViewClientData>? {
        val client = tab.webViewClient
        // Check if the webViewClient is an instance of RedBrowserWebViewClient
        return if (client != null && client is RedBrowserWebViewClient) {
            client.data
        } else {
            // Handle the case where the webViewClient is not of expected type
            null
        }
    }
}
