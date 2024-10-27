package com.browser.red.domain.usecases.homeicon

import com.browser.red.domain.model.HomeIcon

/**
 * Use case for retrieving a list of [HomeIcon] items from the repository.
 *
 * This interface defines the contract for obtaining all saved home icons,
 * which can be used to display or manage icons on the home screen.
 */
interface GetHomeIconUseCase {

    /**
     * Retrieves a list of all [HomeIcon] items.
     *
     * @return A list of [HomeIcon] items.
     */
    operator fun invoke(): List<HomeIcon>
}
