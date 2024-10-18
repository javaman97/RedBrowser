package com.browser.core_browser.domain.usecases

import android.webkit.WebViewClient
import com.browser.core_browser.domain.model.RedBrowserTab
import com.browser.core_browser.domain.repository.RedBrowserRepository

/**
 * Implementation of the [SetWebViewClientUseCase] interface for setting a [WebViewClient]
 * for a specific [RedBrowserTab].
 *
 * This class provides the logic to assign a [WebViewClient] to a tab
 * by interacting with the [RedBrowserRepository].
 *
 * @param repository The [RedBrowserRepository] instance used to set the [WebViewClient].
 */
internal class SetWebViewClientUseCaseImpl(
    private val repository: RedBrowserRepository
) : SetWebViewClientUseCase {

    /**
     * Sets the specified [WebViewClient] for the given [tab].
     *
     * @param tab The [RedBrowserTab] for which the [WebViewClient] is to be set.
     * @param client The [WebViewClient] instance to be assigned to the specified tab.
     */
    override fun invoke(tab: RedBrowserTab, client: WebViewClient) {
        repository.setWebViewClient(tab, client)
    }
}
