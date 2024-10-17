package com.browser.core_browser.di

import com.browser.core_browser.data.repository.RedBrowserRepositoryImpl
import com.browser.core_browser.domain.repository.RedBrowserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Hilt module for providing core dependencies related to the RedBrowser.
 * This module ensures that the [RedBrowserRepository] interface is provided
 * throughout the app and its implementation is hidden from other layers.
 */
@Module
@InstallIn(SingletonComponent::class)
object CoreBrowserModule {

    /**
     * Provides a singleton instance of [RedBrowserRepository].
     *
     * The instance is created using the [RedBrowserRepositoryImpl] class,
     * ensuring that other components only depend on the interface and not the implementation.
     *
     * @return An instance of [RedBrowserRepository].
     */
    @Provides
    @Singleton
    fun provideRedBrowserRepository(): RedBrowserRepository {
        return RedBrowserRepositoryImpl()
    }
}
