package com.browser.red.domain.usecases.homeicon

import com.browser.red.domain.HomeIconRepository
import com.browser.red.domain.model.HomeIcon

/**
 * Implementation of [GetHomeIconUseCase] that retrieves a list of home icons
 * from the specified [HomeIconRepository].
 *
 * This use case enables the retrieval of all saved [HomeIcon] items, which can be
 * displayed or managed on the home screen.
 *
 * @property homeIconRepository The repository instance responsible for managing [HomeIcon] data.
 */
class GetHomeIconUseCaseImpl(
    private val homeIconRepository: HomeIconRepository
) : GetHomeIconUseCase {

    /**
     * Invokes the use case to retrieve a list of all [HomeIcon] items.
     *
     * @return A list of [HomeIcon] items from the repository.
     */
    override fun invoke(): List<HomeIcon> {
        return homeIconRepository.listIcons()
    }
}
