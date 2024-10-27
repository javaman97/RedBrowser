package com.browser.red.data

import com.browser.red.R
import com.browser.red.domain.HomeIconRepository
import com.browser.red.domain.model.HomeIcon

/**
 * Implementation of [HomeIconRepository] for managing home screen icons.
 *
 * This repository provides functionality to add icons to a list and retrieve the list of all icons.
 * It stores icons in an internal [MutableList] of [HomeIcon] objects.
 *
 * @property list A mutable list that holds the icons for the home screen.
 */
class HomeIconRepositoryImpl(
    private val list: MutableList<HomeIcon> = mutableListOf()
) : HomeIconRepository {
    /**
     * Adds a [HomeIcon] to the internal list.
     *
     * @param icon The [HomeIcon] to add to the list.
     */
    override fun addIcon(icon: HomeIcon) {
        list.add(icon)
    }

    /**
     * Returns a list of all [HomeIcon] objects.
     *
     * @return A [List] of [HomeIcon] representing the icons on the home screen.
     */
    override fun listIcons(): List<HomeIcon> {
        return list
    }
}
