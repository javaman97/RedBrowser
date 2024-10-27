package com.browser.red.domain.di

import com.browser.red.domain.HomeIconRepository
import com.browser.red.domain.usecases.homeicon.AddHomeIconUseCase
import com.browser.red.domain.usecases.homeicon.AddHomeIconUseCaseImpl
import com.browser.red.domain.usecases.homeicon.GetHomeIconUseCase
import com.browser.red.domain.usecases.homeicon.GetHomeIconUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger Hilt module for providing use case implementations to be used throughout the application.
 *
 * This module binds use case interfaces to their respective implementations,
 * allowing for dependency injection of use cases in the application's components.
 */
@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    /**
     * Provides a singleton instance of [AddHomeIconUseCase].
     *
     * @param repository The [HomeIconRepository] to be used within the use case.
     * @return An instance of [AddHomeIconUseCaseImpl], which implements [AddHomeIconUseCase].
     */
    @Singleton
    @Provides
    fun providesAddHomeIconUseCase(repository: HomeIconRepository): AddHomeIconUseCase {
        return AddHomeIconUseCaseImpl(repository)
    }

    /**
     * Provides a singleton instance of [GetHomeIconUseCase].
     *
     * @param repository The [HomeIconRepository] to be used within the use case.
     * @return An instance of [GetHomeIconUseCaseImpl], which implements [GetHomeIconUseCase].
     */
    @Singleton
    @Provides
    fun providesGetHomeIconsUseCase(repository: HomeIconRepository): GetHomeIconUseCase {
        return GetHomeIconUseCaseImpl(repository)
    }
}
