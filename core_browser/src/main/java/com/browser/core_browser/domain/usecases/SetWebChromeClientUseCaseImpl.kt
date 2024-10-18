package com.browser.core_browser.domain.usecases

import android.webkit.WebChromeClient
import com.browser.core_browser.domain.model.RedBrowserTab
import com.browser.core_browser.domain.repository.RedBrowserRepository

/**
 * Implementation of the [SetWebChromeClientUseCase] interface.
 *
 * This class provides the functionality to set a [WebChromeClient]
 * for a specific [RedBrowserTab] by delegating the responsibility
 * to the [RedBrowserRepository].
 *
 * @param repository The [RedBrowserRepository] instance used to set the [WebChromeClient].
 */
internal class SetWebChromeClientUseCaseImpl(
    private val repository: RedBrowserRepository
) : SetWebChromeClientUseCase {

    /**
     * Sets the specified [WebChromeClient] for the given [tab].
     *
     * @param tab The [RedBrowserTab] for which the [WebChromeClient] is to be set.
     * @param client The [WebChromeClient] instance to be assigned to the specified tab.
     */
    override fun invoke(tab: RedBrowserTab, client: WebChromeClient) {
        repository.setWebChromeClient(tab, client)
    }
}
