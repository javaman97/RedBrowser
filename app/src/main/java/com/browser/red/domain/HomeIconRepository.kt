package com.browser.red.domain

import com.browser.red.domain.model.HomeIcon

/**
 * Repository interface for managing home icons in the browser.
 *
 * This repository provides methods for adding new icons and listing all
 * available icons on the home screen. It acts as an abstraction over the data
 * source that handles home icon data, allowing flexibility in the data storage
 * and retrieval mechanism.
 */
interface HomeIconRepository {
    /**
     * Adds a new icon to the home screen.
     *
     * @param icon The [HomeIcon] to be added.
     */
    fun addIcon(icon: HomeIcon)

    /**
     * Retrieves a list of all icons available on the home screen.
     *
     * @return A list of [HomeIcon] instances representing the icons.
     */
    fun listIcons(): List<HomeIcon>
}
