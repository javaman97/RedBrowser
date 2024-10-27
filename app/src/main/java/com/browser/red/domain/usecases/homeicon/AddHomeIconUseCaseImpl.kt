package com.browser.red.domain.usecases.homeicon

import com.browser.red.domain.HomeIconRepository
import com.browser.red.domain.model.HomeIcon

class AddHomeIconUseCaseImpl(private val homeIconRepository: HomeIconRepository):AddHomeIconUseCase {
    override fun invoke(icon: HomeIcon) {
        homeIconRepository.addIcon(icon)
    }
}