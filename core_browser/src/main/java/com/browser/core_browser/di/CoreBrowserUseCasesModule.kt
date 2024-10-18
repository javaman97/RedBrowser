package com.browser.core_browser.di

import com.browser.core_browser.domain.manager.TabManager
import com.browser.core_browser.domain.repository.RedBrowserRepository
import com.browser.core_browser.domain.usecases.ConfigureWebViewUseCase
import com.browser.core_browser.domain.usecases.ConfigureWebViewUseCaseImpl
import com.browser.core_browser.domain.usecases.GetCurrentTabUseCase
import com.browser.core_browser.domain.usecases.GetCurrentTabUseCaseImpl
import com.browser.core_browser.domain.usecases.LoadUrlUseCase
import com.browser.core_browser.domain.usecases.LoadUrlUseCaseImpl
import com.browser.core_browser.domain.usecases.ObserveWebViewClientDataUseCase
import com.browser.core_browser.domain.usecases.ObserveWebViewClientDataUseCaseImpl
import com.browser.core_browser.domain.usecases.OpenNewTabUseCase
import com.browser.core_browser.domain.usecases.OpenNewTabUseCaseImpl
import com.browser.core_browser.domain.usecases.SetWebChromeClientUseCase
import com.browser.core_browser.domain.usecases.SetWebChromeClientUseCaseImpl
import com.browser.core_browser.domain.usecases.SetWebViewClientUseCase
import com.browser.core_browser.domain.usecases.SetWebViewClientUseCaseImpl
import com.browser.core_browser.domain.usecases.SwitchToTabUseCase
import com.browser.core_browser.domain.usecases.SwitchToTabUseCaseImpl
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
    fun providesConfigureWebViewUseCase(repository: RedBrowserRepository): ConfigureWebViewUseCase {
        return ConfigureWebViewUseCaseImpl(repository)
    }

    @Singleton
    @Provides
    fun providesGetCurrentTabUseCase(tabManager: TabManager): GetCurrentTabUseCase {
        return GetCurrentTabUseCaseImpl(tabManager)
    }

    @Singleton
    @Provides
    fun providesSetWebViewClientUseCase(repository: RedBrowserRepository):SetWebViewClientUseCase{
        return SetWebViewClientUseCaseImpl(repository)
    }

    @Singleton
    @Provides
    fun providesSetWebChromeClientUseCase(repository: RedBrowserRepository):SetWebChromeClientUseCase{
        return SetWebChromeClientUseCaseImpl(repository)
    }

    @Singleton
    @Provides
    fun providesSwitchToTabUseCase(tabManager: TabManager):SwitchToTabUseCase{
        return SwitchToTabUseCaseImpl(tabManager)
    }

    @Singleton
    @Provides
    fun providesObserveWebViewClientDataUseCase():ObserveWebViewClientDataUseCase{
        return ObserveWebViewClientDataUseCaseImpl()
    }
}