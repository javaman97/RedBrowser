package com.browser.red.domain.di

import com.browser.red.data.HomeIconRepositoryImpl
import com.browser.red.domain.HomeIconRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger Hilt module for providing repository implementations to be used across the application.
 *
 * This module includes bindings for repository interfaces to their concrete implementations,
 * enabling dependency injection of repositories where needed.
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    /**
     * Provides a singleton instance of [HomeIconRepository].
     *
     * @return An instance of [HomeIconRepositoryImpl], which implements [HomeIconRepository].
     */
    @Singleton
    @Provides
    fun providesHomeIconRepository(): HomeIconRepository {
        return HomeIconRepositoryImpl()
    }
}
