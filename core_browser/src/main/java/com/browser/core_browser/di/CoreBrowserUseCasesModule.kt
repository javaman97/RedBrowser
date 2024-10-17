package com.browser.core_browser.di

import com.browser.core_browser.domain.manager.TabManager
import com.browser.core_browser.domain.repository.RedBrowserRepository
import com.browser.core_browser.domain.usecases.ConfigureWebViewUseCase
import com.browser.core_browser.domain.usecases.ConfigureWebViewUseCaseImpl
import com.browser.core_browser.domain.usecases.GetCurrentTabUseCase
import com.browser.core_browser.domain.usecases.GetCurrentTabUseCaseImpl
import com.browser.core_browser.domain.usecases.LoadUrlUseCase
import com.browser.core_browser.domain.usecases.LoadUrlUseCaseImpl
import com.browser.core_browser.domain.usecases.OpenNewTabUseCase
import com.browser.core_browser.domain.usecases.OpenNewTabUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CoreBrowserUseCasesModule {

    @Singleton
    @Provides
    fun providesOpenNewTabUseCase(tabManager: TabManager):OpenNewTabUseCase{
        return OpenNewTabUseCaseImpl(tabManager)
    }

    @Singleton
    @Provides
    fun providesLoadUrlUseCase(repository: RedBrowserRepository):LoadUrlUseCase{
        return LoadUrlUseCaseImpl(repository)
    }

    @Singleton
    @Provides
    fun providesConfigureWebViewUseCase(repository: RedBrowserRepository):ConfigureWebViewUseCase{
        return ConfigureWebViewUseCaseImpl(repository)
    }

    @Singleton
    @Provides
    fun providesGetCurrentTabUseCase(tabManager: TabManager):GetCurrentTabUseCase{
        return GetCurrentTabUseCaseImpl(tabManager)
    }
}