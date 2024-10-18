package com.browser.core_browser.domain.usecases

import android.webkit.WebViewClient
import com.browser.core_browser.domain.model.RedBrowserTab

/**
 * Use case interface for setting a [WebViewClient] for a specific [RedBrowserTab].
 *
 * This interface defines the contract for implementations that manage
 * the assignment of a [WebViewClient] to a particular tab in the browser.
 */
interface SetWebViewClientUseCase {

    /**
     * Sets the specified [WebViewClient] for the given [tab].
     *
     * @param tab The [RedBrowserTab] for which the [WebViewClient] is to be set.
     * @param client The [WebViewClient] instance to be assigned to the specified tab.
     */
    operator fun invoke(tab: RedBrowserTab, client: WebViewClient)
}
