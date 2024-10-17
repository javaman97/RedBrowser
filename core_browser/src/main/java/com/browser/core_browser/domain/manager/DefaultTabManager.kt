package com.browser.core_browser.domain.manager

import android.webkit.WebView
import com.browser.core_browser.domain.model.RedBrowserTab
import java.util.UUID

/**
 * Default implementation of the [TabManager] interface.
 *
 * Manages the lifecycle of browser tabs, including creating, switching, and closing tabs.
 */
class DefaultTabManager : TabManager {
    private val tabs = mutableListOf<RedBrowserTab>()
    private var currentTabIndex = 0

    /**
     * Opens a new tab with the given [webView] and [url], and sets it as the current tab.
     *
     * @param webView The WebView to be associated with the new tab.
     * @param url The URL to be loaded in the new tab.
     * @return The newly created [RedBrowserTab].
     */
    override fun openNewTab(webView: WebView, url: String): RedBrowserTab {
        val newTab = RedBrowserTab(webView = webView, url = url)
        tabs.add(newTab)
        currentTabIndex = tabs.lastIndex
        return newTab
    }

    /**
     * Closes the current tab and switches to the last open tab if the current one is removed.
     */
    override fun closeCurrentTab() {
        if (tabs.isNotEmpty()) {
            tabs.removeAt(currentTabIndex)
            if (currentTabIndex >= tabs.size) {
                currentTabIndex = tabs.lastIndex
            }
        }
    }

    /**
     * Switches to the tab at the specified [index].
     *
     * @param index The index of the tab to switch to.
     */
    override fun switchToTab(index: Int) {
        if (index in 0 until tabs.size) {
            currentTabIndex = index
        }
    }

    /**
     * Returns the currently active tab, or null if no tabs are open.
     */
    override fun getCurrentTab(): RedBrowserTab? {
        return if (tabs.isNotEmpty()) tabs[currentTabIndex] else null
    }

    /**
     * Finds and returns a tab by its unique [id].
     *
     * @param id The UUID of the tab to find.
     * @return The corresponding [RedBrowserTab], or null if no tab with the given ID exists.
     */
    override fun getTabById(id: UUID): RedBrowserTab? {
        return tabs.find { it.id == id }
    }

    /**
     * Returns the total number of open tabs.
     *
     * @return The total number of open tabs.
     */
    override fun getTabCount(): Int {
        return tabs.size
    }

    /**
     * Updates the URL of the currently active tab.
     *
     * @param url The new URL to be set for the current tab.
     */
    override fun updateCurrentTabUrl(url: String) {
        tabs.getOrNull(currentTabIndex)?.url = url
    }
}
