package com.browser.red.presentation.viewmodel

import android.content.Context
import android.webkit.WebView
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.browser.core_browser.domain.model.RedBrowserTab
import com.browser.core_browser.domain.model.WebViewClientData
import com.browser.core_browser.domain.usecases.*
import com.browser.core_browser.presentation.ui.RedBrowserChromeClient
import com.browser.core_browser.presentation.ui.RedBrowserWebViewClient
import com.browser.red.domain.utils.WebUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

/**
 * ViewModel for managing the UI-related data and interactions for the RedBrowser app.
 *
 * This ViewModel serves as a mediator between the UI and the domain layer, utilizing various
 * use cases to perform actions such as opening new tabs, loading URLs, configuring WebView settings,
 * managing navigation history, observing WebView events, and updating UI states.
 *
 * @param openNewTabUseCase Use case to open a new browser tab.
 * @param loadUrlUseCase Use case to load a URL in the active tab.
 * @param configureWebViewUseCase Use case to configure WebView settings for a tab.
 * @param getCurrentTabUseCase Use case to retrieve the currently active tab.
 * @param setWebViewClientUseCase Use case to set a WebViewClient for a tab.
 * @param setWebChromeClientUseCase Use case to set a WebChromeClient for a tab.
 * @param switchToTabUseCase Use case to switch between browser tabs.
 * @param observeWebViewClientDataUseCase Use case to observe WebViewClient-related data changes.
 * @param observeChromeClientDataUseCase Use case to observe WebChromeClient-related data changes.
 * @param getTabCountUseCase Use case to retrieve the total count of open tabs.
 * @param listTabsUseCase Use case to list all open browser tabs.
 * @param canGoBackUseCase Use case to check if navigation back is possible.
 * @param goBackUseCase Use case to navigate back in the current tab.
 * @param canGoForwardUseCase Use case to check if forward navigation is possible.
 * @param goForwardUseCase Use case to navigate forward in the current tab.
 */
@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val openNewTabUseCase: OpenNewTabUseCase,
    private val loadUrlUseCase: LoadUrlUseCase,
    private val configureWebViewUseCase: ConfigureWebViewUseCase,
    private val getCurrentTabUseCase: GetCurrentTabUseCase,
    private val setWebViewClientUseCase: SetWebViewClientUseCase,
    private val setWebChromeClientUseCase: SetWebChromeClientUseCase,
    private val switchToTabUseCase: SwitchToTabUseCase,
    private val observeWebViewClientDataUseCase: ObserveWebViewClientDataUseCase,
    private val observeChromeClientDataUseCase: ObserveChromeClientData,
    private val getTabCountUseCase: GetTabCountUseCase,
    private val listTabsUseCase: ListTabsUseCase,
    private val canGoBackUseCase: CanGoBackUseCase,
    private val goBackUseCase: GoBackUseCase,
    private val canGoForwardUseCase: CanGoForwardUseCase,
    private val goForwardUseCase: GoForwardUseCase
) : ViewModel() {

    var mCurrentTab by mutableStateOf<RedBrowserTab?>(null)
        private set

    var pageProgress by mutableFloatStateOf(0.0f)
        private set

    var pageTitle by mutableStateOf("")
        private set

    var currentUrl by mutableStateOf("")
        private set

    var canGoBack by mutableStateOf(false)
        private set

    var canGoForward by mutableStateOf(false)
        private set

    var onPageFinished by mutableStateOf(false)
        private set

    var onPageStarted by mutableStateOf(true)
        private set

    var showAddressBarEditable by mutableStateOf(true)

    /**
     * Adds a new tab with the specified [url] and sets up required WebView settings, clients, and observers.
     *
     * @param context The context for creating a new [WebView] instance.
     * @param url The URL to be loaded in the new tab (default is WebUtils.DEFAULT_URL).
     */
    fun addTab(context: Context, url: String = WebUtils.DEFAULT_URL) {
        val tab = openNewTab(WebView(context), url)
        configureWebView(tab)
        setWebViewClient(tab)
        setWebChromeClient(tab)
        mCurrentTab = tab
        observeChromeClientData()
        observeWebViewClientData()
        if(tab.url != WebUtils.DEFAULT_URL){
            loadUrl(tab)
        }
    }

    /**
     * Opens a new tab with the specified [webView] and [url].
     *
     * @param webView The WebView instance for the new tab.
     * @param url The URL to be loaded in the new tab.
     * @return The newly created [RedBrowserTab].
     */
    private fun openNewTab(webView: WebView, url: String): RedBrowserTab {
        return openNewTabUseCase(webView, url).apply {
            mCurrentTab = this
        }
    }

    /**
     * Configures the WebView settings for the specified [tab].
     *
     * @param tab The [RedBrowserTab] whose WebView will be configured.
     */
    fun configureWebView(tab: RedBrowserTab) {
        configureWebViewUseCase(tab)
    }

    /**
     * Loads the current URL in the specified [tab].
     *
     * @param tab The [RedBrowserTab] in which the URL will be loaded.
     */
    fun loadUrl(tab: RedBrowserTab) {
        loadUrlUseCase(tab)
        showAddressBarEditable = false
    }

    /**
     * Switches to the tab at the specified [index].
     *
     * @param index The index of the tab to switch to.
     */
    fun switchToTab(index: Int) {
        val switchedTab = switchToTabUseCase(index)
        if (switchedTab != null) {
            mCurrentTab = switchedTab
        } else {
            Timber.i("Tab switch failed: index $index is out of bounds.")
        }
    }

    /**
     * Retrieves the currently active tab.
     *
     * @return The current [RedBrowserTab] or null if no tabs are open.
     */
    fun getCurrentTab(): RedBrowserTab? = getCurrentTabUseCase()

    /**
     * Sets the WebViewClient for the specified [tab] to handle WebView events.
     *
     * @param tab The [RedBrowserTab] for which the WebViewClient will be set.
     */
    fun setWebViewClient(tab: RedBrowserTab) {
        setWebViewClientUseCase(tab, RedBrowserWebViewClient())
    }

    /**
     * Sets the WebChromeClient for the specified [tab] to manage UI-related events.
     *
     * @param tab The [RedBrowserTab] for which the WebChromeClient will be set.
     */
    fun setWebChromeClient(tab: RedBrowserTab) {
        setWebChromeClientUseCase(tab, RedBrowserChromeClient())
    }

    /**
     * Observes the WebViewClient data events for the active tab, updating state as needed.
     */
    private fun observeWebViewClientData() = viewModelScope.launch(Dispatchers.IO) {
        getCurrentTab()?.let { tab ->
            observeWebViewClientDataUseCase(tab)?.collect { data ->
                onPageStarted = data.onPageStarted
                onPageFinished = data.onPageFinished
                data.url?.let {
                    tab.url = it
                    currentUrl = it
                }
                withContext(Dispatchers.Main) {
                    canGoBack = canGoBackUseCase(tab)
                    canGoForward = canGoForwardUseCase(tab)
                }
            }
        }
    }

    /**
     * Observes WebChromeClient data events for the active tab, updating progress state.
     */
    private fun observeChromeClientData() = viewModelScope.launch(Dispatchers.IO) {
        getCurrentTab()?.let { tab ->
            observeChromeClientDataUseCase(tab)?.collect { data ->
                pageProgress = data.progress / 100f
                pageTitle = data.title.toString()
            }
        }
    }

    /**
     * Retrieves a list of all currently opened tabs.
     *
     * @return A list of [RedBrowserTab] representing all opened tabs.
     */
    fun listTabs(): List<RedBrowserTab> = listTabsUseCase()

    /**
     * Navigates back in the current tab's browsing history, if possible.
     */
    fun goBack() {
        mCurrentTab?.let { goBackUseCase(it) }
    }

    /**
     * Navigates forward in the current tab's browsing history, if possible.
     */
    fun goForward() {
        mCurrentTab?.let { goForwardUseCase(it) }
    }
}
