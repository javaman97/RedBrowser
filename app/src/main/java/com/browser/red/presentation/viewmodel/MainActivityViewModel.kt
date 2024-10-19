package com.browser.red.presentation.viewmodel

import android.content.Context
import android.webkit.WebView
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.browser.core_browser.domain.model.RedBrowserTab
import com.browser.core_browser.domain.model.WebViewClientData
import com.browser.core_browser.domain.usecases.ConfigureWebViewUseCase
import com.browser.core_browser.domain.usecases.GetCurrentTabUseCase
import com.browser.core_browser.domain.usecases.GetTabCountUseCase
import com.browser.core_browser.domain.usecases.LoadUrlUseCase
import com.browser.core_browser.domain.usecases.ObserveWebViewClientDataUseCase
import com.browser.core_browser.domain.usecases.OpenNewTabUseCase
import com.browser.core_browser.domain.usecases.SetWebChromeClientUseCase
import com.browser.core_browser.domain.usecases.SetWebViewClientUseCase
import com.browser.core_browser.domain.usecases.SwitchToTabUseCase
import com.browser.core_browser.presentation.ui.RedBrowserChromeClient
import com.browser.core_browser.presentation.ui.RedBrowserWebViewClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import timber.log.Timber
import javax.inject.Inject

/**
 * ViewModel for managing the UI-related data in the RedBrowser.
 *
 * This ViewModel communicates with use cases to open new tabs, load URLs,
 * configure WebView settings, retrieve the current active tab, and set the WebViewClient
 * and WebChromeClient for individual tabs.
 *
 * @param openNewTabUseCase Use case for opening a new browser tab.
 * @param loadUrlUseCase Use case for loading a URL in the current tab.
 * @param configureWebViewUseCase Use case for configuring the WebView for a tab.
 * @param getCurrentTabUseCase Use case for retrieving the currently active tab.
 * @param setWebViewClientUseCase Use case for setting the WebViewClient for a tab.
 * @param setWebChromeClientUseCase Use case for setting the WebChromeClient for a tab.
 * @param switchToTabUseCase Use case for switching between browser tabs.
 * @param observeWebViewClientDataUseCase Use case for observing required data in WebViewClient
 * @param getTabCountUseCase Use case for getting total tab count
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
    private val getTabCountUseCase: GetTabCountUseCase,
) : ViewModel() {

    private val _currentTab:MutableStateFlow<RedBrowserTab?> = MutableStateFlow(null)
    val currentTab = _currentTab.asStateFlow()

    var mTabCount by mutableStateOf(0)
        private set

    fun initialiseTab(context:Context){
        val tab = openNewTab(WebView(context),"https://www.youtube.com")
        configureWebView(tab)
        setWebViewClient(tab)
        setWebChromeClient(tab)
        loadUrl(tab)
        mTabCount++
    }


    /**
     * Opens a new tab with the specified [webView] and [url].
     *
     * @param webView The WebView instance to be associated with the new tab.
     * @param url The URL to load in the new tab.
     * @return The newly created [RedBrowserTab].
     */
    fun openNewTab(webView: WebView, url: String): RedBrowserTab {
        return openNewTabUseCase(webView, url).apply {
            _currentTab.value = this
        }

    }

    /**
     * Configures the WebView settings for the specified [tab].
     *
     * @param tab The [RedBrowserTab] to configure.
     */
    fun configureWebView(tab: RedBrowserTab) {
        configureWebViewUseCase(tab)
    }

    /**
     * Loads the URL for the specified [tab].
     *
     * @param tab The [RedBrowserTab] for which to load the URL.
     */
    fun loadUrl(tab: RedBrowserTab) {
        loadUrlUseCase(tab)
    }

    /**
     * Switches to the tab at the specified [index].
     *
     * This method invokes the [SwitchToTabUseCase] to switch to the tab at the given [index].
     * If the switch is successful, it can trigger any necessary UI updates.
     * If the index is out of bounds, a warning is logged for debugging purposes.
     *
     * @param index The index of the tab to switch to. Should be within the range of available tabs.
     * @see SwitchToTabUseCase
     */
    fun switchToTab(index: Int) {
        val switchedTab = switchToTabUseCase(index)
        if (switchedTab != null) {
            _currentTab.value = switchedTab
        } else {
            // Handle the case where the tab switch failed
            Timber.i("Tab switch failed: index $index is out of bounds.")
        }
    }

    /**
     * Retrieves the currently active tab.
     *
     * @return The currently active [RedBrowserTab], or null if no tabs are open.
     */
    fun getCurrentTab(): RedBrowserTab? {
        return getCurrentTabUseCase()
    }

    /**
     * Sets the WebViewClient for the specified [tab].
     *
     * This method uses the [SetWebViewClientUseCase] to set a custom [RedBrowserWebViewClient]
     * for handling WebView events related to the specified tab.
     *
     * @param tab The [RedBrowserTab] for which to set the WebViewClient.
     */
    fun setWebViewClient(tab: RedBrowserTab) {
        setWebViewClientUseCase(tab, RedBrowserWebViewClient())
    }

    /**
     * Sets the WebChromeClient for the specified [tab].
     *
     * This method uses the [SetWebChromeClientUseCase] to set a custom [RedBrowserChromeClient]
     * for managing UI-related changes, such as progress updates and title changes for the specified tab.
     *
     * @param tab The [RedBrowserTab] for which to set the WebChromeClient.
     */
    fun setWebChromeClient(tab: RedBrowserTab) {
        setWebChromeClientUseCase(tab, RedBrowserChromeClient())
    }

    /**
     * Observes the [WebViewClientData] for the currently active tab.
     *
     * This method retrieves the current tab using the [getCurrentTabUseCase] and,
     * if a tab is available, it invokes the [observeWebViewClientDataUseCase]
     * to return the associated [StateFlow] of [WebViewClientData].
     * If there is no active tab, it returns null.
     *
     * @return A [StateFlow] of [WebViewClientData] associated with the current tab,
     * or null if there is no active tab.
     */
    fun observeWebViewClientData(): StateFlow<WebViewClientData>? {
        val currentTab = getCurrentTabUseCase()
        return if (currentTab != null) {
            observeWebViewClientDataUseCase(currentTab)
        } else {
            null
        }
    }

    fun getTabCount():Int{
       return getTabCountUseCase()
    }

}
