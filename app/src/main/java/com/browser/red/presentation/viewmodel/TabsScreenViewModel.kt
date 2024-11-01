package com.browser.red.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.browser.core_browser.domain.model.RedBrowserTab
import com.browser.core_browser.domain.usecases.CloseTabUseCase
import com.browser.core_browser.domain.usecases.ListTabsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * ViewModel for managing the tabs screen in the browser application.
 *
 * This ViewModel acts as an intermediary between the UI and the use cases for listing
 * and closing browser tabs. It retrieves the current state of open tabs and facilitates
 * the closure of specified tabs.
 *
 * @property listTabsUseCase The use case for retrieving the list of currently opened tabs.
 * @property closeTabUseCase The use case for closing a specified browser tab.
 */
@HiltViewModel
class TabsScreenViewModel @Inject constructor(
    private val listTabsUseCase: ListTabsUseCase,
    private val closeTabUseCase: CloseTabUseCase
) : ViewModel() {

    /**
     * Retrieves a list of all currently opened tabs.
     *
     * This function invokes the [listTabsUseCase] to get the current list of active
     * [RedBrowserTab] instances. It is used by the UI to display the tabs available
     * in the browser session.
     *
     * @return A list of [RedBrowserTab] representing all opened tabs.
     */
    fun listTabs(): List<RedBrowserTab> = listTabsUseCase()

    /**
     * Closes the specified browser tab.
     *
     * This function invokes the [closeTabUseCase] to handle the closure of the provided
     * [RedBrowserTab]. It facilitates user actions to manage tab lifecycles effectively.
     *
     * @param tab The [RedBrowserTab] instance to be closed.
     */
    fun closeTab(tab: RedBrowserTab) {
        closeTabUseCase(tab)
    }
}