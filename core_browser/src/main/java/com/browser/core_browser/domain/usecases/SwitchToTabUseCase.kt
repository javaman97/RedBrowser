package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.RedBrowserTab

/**
 * Use case for switching to a specific tab in the browser.
 *
 * @property index The index of the tab to switch to.
 * @return The [RedBrowserTab] that is now the current tab, or null if the index is out of bounds.
 */
interface SwitchToTabUseCase {
    operator fun invoke(index: Int): RedBrowserTab?
}
