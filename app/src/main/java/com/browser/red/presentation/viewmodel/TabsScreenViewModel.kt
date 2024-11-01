package com.browser.red.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.browser.core_browser.domain.model.RedBrowserTab
import com.browser.core_browser.domain.usecases.CloseTabUseCase
import com.browser.core_browser.domain.usecases.ListTabsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TabsScreenViewModel @Inject constructor(
    private val listTabsUseCase: ListTabsUseCase,
    private val closeTabUseCase: CloseTabUseCase
):ViewModel() {
    /**
     * Retrieves a list of all currently opened tabs.
     *
     * @return A list of [RedBrowserTab] representing all opened tabs.
     */
    fun listTabs(): List<RedBrowserTab> = listTabsUseCase()

    fun closeTab(tab: RedBrowserTab){
        closeTabUseCase(tab)
    }
}