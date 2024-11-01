package com.browser.core_browser.domain.manager

import android.graphics.Bitmap
import android.webkit.WebView
import android.webkit.WebViewClient
import com.browser.core_browser.domain.model.RedBrowserTab
import java.util.UUID

/**
 * Defines the contract for managing browser tabs in RedBrowser.
 *
 * This interface includes methods for opening, closing, switching between tabs, and updating the URL of the current tab.
 */
interface TabManager {

    /**
     * Opens a new browser tab with the given [webView] and [url].
     *
     * @param webView The WebView instance associated with the new tab.
     * @param url The URL to be loaded in the new tab.
     * @return The newly created [RedBrowserTab].
     */
    fun openNewTab(webView: WebView, url: String): RedBrowserTab

    /**
     * Closes the current tab.
     *
     * If no tabs are left, no action is performed.
     */
    fun closeCurrentTab()

    fun closeTab(tab: RedBrowserTab)

    /**
     * Switches to the tab at the specified [index].
     *
     * @param index The index of the tab to switch to. If the index is out of bounds,
     *              no action is taken, and the current tab remains unchanged.
     * @return The newly active [RedBrowserTab] after switching, or null if no tab exists
     *         at the specified index.
     */
    fun switchToTab(index: Int): RedBrowserTab?


    /**
     * Returns the currently active tab.
     *
     * @return The currently selected [RedBrowserTab], or null if no tabs are open.
     */
    fun getCurrentTab(): RedBrowserTab?

    /**
     * Finds a tab by its [id].
     *
     * @param id The UUID of the tab to find.
     * @return The corresponding [RedBrowserTab], or null if no tab with the given ID exists.
     */
    fun getTabById(id: UUID): RedBrowserTab?

    /**
     * Gets the total number of open tabs.
     *
     * @return The number of tabs currently open.
     */
    fun getTabCount(): Int

    /**
     * Updates the URL of the currently active tab.
     *
     * @param url The new URL to be set for the current tab.
     */
    fun updateCurrentTabUrl(url: String)


    fun listTabs():List<RedBrowserTab>

    fun setThumbnail(id:UUID,thumbnail:Bitmap)

}
