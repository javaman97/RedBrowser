package com.browser.core_browser.domain.usecases

/**
 * Use case interface for retrieving the current count of browser tabs.
 *
 * This use case is responsible for returning the number of open tabs in the browser.
 * It is typically invoked when the application needs to display the current tab count
 * or perform actions based on the number of open tabs.
 */
interface GetTabCountUseCase {
    /**
     * Returns the current number of open tabs in the browser.
     *
     * @return The total number of open tabs.
     */
    operator fun invoke(): Int
}
