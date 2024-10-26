package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.RedBrowserTab
import com.browser.core_browser.domain.repository.RedBrowserRepository

/**
 * Implementation of [GoBackUseCase] for navigating back within a browser tab's history.
 *
 * This class provides functionality to initiate back navigation by invoking
 * the corresponding method in [RedBrowserRepository].
 *
 * @param repository The repository responsible for managing browser navigation.
 */
internal class GoBackUseCaseImpl(private val repository: RedBrowserRepository) : GoBackUseCase {

    /**
     * Invokes back navigation within the specified [tab]'s browsing history.
     *
     * @param tab The [RedBrowserTab] in which to perform back navigation.
     */
    override fun invoke(tab: RedBrowserTab) {
        repository.goBack(tab)
    }
}
