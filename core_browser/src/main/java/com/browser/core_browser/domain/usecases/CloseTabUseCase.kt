package com.browser.core_browser.domain.usecases

import com.browser.core_browser.domain.model.RedBrowserTab

/**
 * A use case interface for closing a specified browser tab.
 *
 * This interface defines a contract for closing a browser tab instance, allowing
 * the removal of the tab from the active session and freeing up resources.
 */
interface CloseTabUseCase {

    /**
     * Closes the specified browser tab.
     *
     * This operator function is designed to be invoked like a function, making it simple
     * to close a tab by passing in the relevant [RedBrowserTab] instance. Implementations
     * of this use case handle the cleanup or removal of the tab from active management.
     *
     * @param tab The [RedBrowserTab] instance to be closed.
     */
    operator fun invoke(tab: RedBrowserTab)
}
