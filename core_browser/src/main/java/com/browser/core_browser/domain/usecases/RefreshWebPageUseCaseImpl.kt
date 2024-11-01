package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.RedBrowserTab
import com.browser.core_browser.domain.repository.RedBrowserRepository

/**
 * Implementation of the [RefreshWebPageUseCase] interface, responsible for refreshing the content of a specified browser tab.
 *
 * This class interacts with the [RedBrowserRepository] to perform the necessary operations for reloading
 * the webpage associated with a given tab. It ensures that users can access the most up-to-date content
 * in their browser sessions.
 *
 * @property repository The [RedBrowserRepository] instance used to handle data operations related to browser tabs.
 */
internal class RefreshWebPageUseCaseImpl(private val repository: RedBrowserRepository) : RefreshWebPageUseCase {

    /**
     * Refreshes the content of the specified browser tab.
     *
     * This function overrides the `invoke` operator function in the [RefreshWebPageUseCase] interface.
     * It delegates the refresh operation to the [RedBrowserRepository], which updates the content
     * displayed in the specified [RedBrowserTab].
     *
     * @param tab The [RedBrowserTab] instance to be refreshed.
     */
    override fun invoke(tab: RedBrowserTab) {
        repository.refreshWebPage(tab)
    }
}
