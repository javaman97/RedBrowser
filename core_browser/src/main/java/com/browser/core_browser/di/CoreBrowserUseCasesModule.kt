package com.browser.core_browser.di

import com.browser.core_browser.domain.manager.TabManager
import com.browser.core_browser.domain.repository.RedBrowserRepository
import com.browser.core_browser.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger Hilt module responsible for providing implementations of use cases
 * related to the core browser functionality. These use cases facilitate
 * browser tab management, WebView configuration, URL loading, and more.
 */
@Module
@InstallIn(SingletonComponent::class)
object CoreBrowserUseCasesModule {

    /**
     * Provides an implementation of [OpenNewTabUseCase] using the provided [TabManager].
     *
     * @param tabManager The [TabManager] responsible for managing browser tabs.
     * @return An instance of [OpenNewTabUseCaseImpl].
     */
    @Singleton
    @Provides
    fun providesOpenNewTabUseCase(tabManager: TabManager): OpenNewTabUseCase {
        return OpenNewTabUseCaseImpl(tabManager)
    }

    /**
     * Provides an implementation of [LoadUrlUseCase] using the provided [RedBrowserRepository].
     *
     * @param repository The [RedBrowserRepository] responsible for managing WebView settings and data.
     * @return An instance of [LoadUrlUseCaseImpl].
     */
    @Singleton
    @Provides
    fun providesLoadUrlUseCase(repository: RedBrowserRepository): LoadUrlUseCase {
        return LoadUrlUseCaseImpl(repository)
    }

    /**
     * Provides an implementation of [ConfigureWebViewUseCase] using the provided [RedBrowserRepository].
     *
     * @param repository The [RedBrowserRepository] for managing WebView settings.
     * @return An instance of [ConfigureWebViewUseCaseImpl].
     */
    @Singleton
    @Provides
    fun providesConfigureWebViewUseCase(repository: RedBrowserRepository): ConfigureWebViewUseCase {
        return ConfigureWebViewUseCaseImpl(repository)
    }

    /**
     * Provides an implementation of [GetCurrentTabUseCase] using the provided [TabManager].
     *
     * @param tabManager The [TabManager] for managing the currently active tab.
     * @return An instance of [GetCurrentTabUseCaseImpl].
     */
    @Singleton
    @Provides
    fun providesGetCurrentTabUseCase(tabManager: TabManager): GetCurrentTabUseCase {
        return GetCurrentTabUseCaseImpl(tabManager)
    }

    /**
     * Provides an implementation of [SetWebViewClientUseCase] using the provided [RedBrowserRepository].
     *
     * @param repository The [RedBrowserRepository] to set the WebViewClient for a WebView.
     * @return An instance of [SetWebViewClientUseCaseImpl].
     */
    @Singleton
    @Provides
    fun providesSetWebViewClientUseCase(repository: RedBrowserRepository): SetWebViewClientUseCase {
        return SetWebViewClientUseCaseImpl(repository)
    }

    /**
     * Provides an implementation of [SetWebChromeClientUseCase] using the provided [RedBrowserRepository].
     *
     * @param repository The [RedBrowserRepository] to set the WebChromeClient for a WebView.
     * @return An instance of [SetWebChromeClientUseCaseImpl].
     */
    @Singleton
    @Provides
    fun providesSetWebChromeClientUseCase(repository: RedBrowserRepository): SetWebChromeClientUseCase {
        return SetWebChromeClientUseCaseImpl(repository)
    }

    /**
     * Provides an implementation of [SwitchToTabUseCase] using the provided [TabManager].
     *
     * @param tabManager The [TabManager] for switching between browser tabs.
     * @return An instance of [SwitchToTabUseCaseImpl].
     */
    @Singleton
    @Provides
    fun providesSwitchToTabUseCase(tabManager: TabManager): SwitchToTabUseCase {
        return SwitchToTabUseCaseImpl(tabManager)
    }

    /**
     * Provides an implementation of [ObserveWebViewClientDataUseCase].
     *
     * This use case is used to observe data changes within a WebViewClient for the active tab.
     *
     * @return An instance of [ObserveWebViewClientDataUseCaseImpl].
     */
    @Singleton
    @Provides
    fun providesObserveWebViewClientDataUseCase(): ObserveWebViewClientDataUseCase {
        return ObserveWebViewClientDataUseCaseImpl()
    }

    /**
     * Provides an implementation of [GetTabCountUseCase] using the provided [TabManager].
     *
     * @param tabManager The [TabManager] responsible for managing browser tabs.
     * @return An instance of [GetTabCountUseCaseImpl].
     */
    @Singleton
    @Provides
    fun providesGetTabCountUseCase(tabManager: TabManager): GetTabCountUseCase {
        return GetTabCountUseCaseImpl(tabManager)
    }

    @Singleton
    @Provides
    fun providesListTabsUseCase(tabManager: TabManager):ListTabsUseCase{
        return ListTabsUseCaseImpl(tabManager)
    }
}
