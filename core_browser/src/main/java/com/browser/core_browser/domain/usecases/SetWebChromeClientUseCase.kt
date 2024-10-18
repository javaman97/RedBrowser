package com.browser.core_browser.domain.usecases

import android.webkit.WebChromeClient
import com.browser.core_browser.domain.model.RedBrowserTab

/**
 * Interface for setting a [WebChromeClient] for a specific [RedBrowserTab].
 *
 * This use case encapsulates the logic for assigning a custom [WebChromeClient]
 * to a tab, enabling functionality such as handling JavaScript dialogs, favicons,
 * titles, and the progress of web page loading.
 *
 * @param tab The [RedBrowserTab] for which the [WebChromeClient] is to be set.
 * @param client The [WebChromeClient] instance to be assigned to the specified tab.
 */
interface SetWebChromeClientUseCase {
    operator fun invoke(tab: RedBrowserTab, client: WebChromeClient)
}
