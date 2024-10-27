package com.browser.red.domain.usecases.homeicon

import com.browser.red.domain.model.HomeIcon

/**
 * Use case for adding a [HomeIcon] to the home screen.
 *
 * Defines a contract for adding a new home icon, which should be implemented by a concrete class.
 */
interface AddHomeIconUseCase {

    /**
     * Adds the provided [HomeIcon] to the home screen.
     *
     * @param icon The [HomeIcon] to add.
     */
    operator fun invoke(icon: HomeIcon)
}
