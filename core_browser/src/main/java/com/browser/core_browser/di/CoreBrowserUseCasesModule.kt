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
     * Provides an implementation of [ObserveChromeClientDataUseCase].
     *
     * This use case is used to observe data changes within a WebChromeClient for the active tab.
     *
     * @return An instance of [ObserveChromeClientDataImpl].
     */
    @Singleton
    @Provides
    fun provideObserveChromeClientDataUseCase(): ObserveChromeClientData {
        return ObserveChromeClientDataImpl()
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

    /**
     * Provides an implementation of [ListTabsUseCase] using the provided [TabManager].
     *
     * @param tabManager The [TabManager] responsible for managing browser tabs.
     * @return An instance of [ListTabsUseCaseImpl].
     */
    @Singleton
    @Provides
    fun providesListTabsUseCase(tabManager: TabManager): ListTabsUseCase {
        return ListTabsUseCaseImpl(tabManager)
    }

    /**
     * Provides an implementation of [CanGoBackUseCase] using the provided [RedBrowserRepository].
     *
     * @param repository The [RedBrowserRepository] for checking if navigation back is possible.
     * @return An instance of [CanGoBackUseCaseImpl].
     */
    @Singleton
    @Provides
    fun providesCanGoBackUseCase(repository: RedBrowserRepository): CanGoBackUseCase {
        return CanGoBackUseCaseImpl(repository)
    }

    /**
     * Provides an implementation of [GoBackUseCase] using the provided [RedBrowserRepository].
     *
     * @param repository The [RedBrowserRepository] for navigating back in a tab's history.
     * @return An instance of [GoBackUseCaseImpl].
     */
    @Singleton
    @Provides
    fun providesGoBackUseCase(repository: RedBrowserRepository): GoBackUseCase {
        return GoBackUseCaseImpl(repository)
    }

    /**
     * Provides an implementation of [CanGoForwardUseCase] using the provided [RedBrowserRepository].
     *
     * @param repository The [RedBrowserRepository] for checking if navigation forward is possible.
     * @return An instance of [CanGoForwardUseCaseImpl].
     */
    @Singleton
    @Provides
    fun providesCanGoForwardUseCase(repository: RedBrowserRepository): CanGoForwardUseCase {
        return CanGoForwardUseCaseImpl(repository)
    }

    /**
     * Provides an implementation of [GoForwardUseCase] using the provided [RedBrowserRepository].
     *
     * @param repository The [RedBrowserRepository] for navigating forward in a tab's history.
     * @return An instance of [GoForwardUseCaseImpl].
     */
    @Singleton
    @Provides
    fun providesGoForwardUseCase(repository: RedBrowserRepository): GoForwardUseCase {
        return GoForwardUseCaseImpl(repository)
    }

    /**
     * Provides an instance of [SetThumbnailUseCase] for dependency injection.
     *
     * This function supplies a singleton [SetThumbnailUseCase] implementation, which
     * manages setting thumbnail images for browser tabs, allowing tab previews to be
     * displayed to the user. The instance is constructed with a [TabManager] to manage
     * the active tabs.
     *
     * @param tabManager The [TabManager] responsible for managing active browser tabs.
     * @return A singleton instance of [SetThumbnailUseCase].
     */
    @Singleton
    @Provides
    fun providesSetThumbnailUseCase(tabManager: TabManager): SetThumbnailUseCase {
        return SetThumbnailUseCaseImpl(tabManager)
    }

    /**
     * Provides an instance of [CloseTabUseCase] for dependency injection.
     *
     * This function supplies a singleton [CloseTabUseCase] implementation to handle
     * the closing of browser tabs, facilitating resource management and user navigation.
     * It utilizes a [TabManager] to identify and manage tabs marked for closure.
     *
     * @param tabManager The [TabManager] responsible for managing active browser tabs.
     * @return A singleton instance of [CloseTabUseCase].
     */
    @Singleton
    @Provides
    fun providesCloseTabUseCase(tabManager: TabManager): CloseTabUseCase {
        return CloseTabUseCaseImpl(tabManager)
    }

    /**
     * Provides an instance of [RefreshWebPageUseCase] for dependency injection.
     *
     * This function supplies a singleton [RefreshWebPageUseCase] implementation, which
     * handles the reloading of web pages in a specified browser tab to ensure updated
     * content display. It uses a [RedBrowserRepository] for accessing or interacting
     * with repository data.
     *
     * @param repository The [RedBrowserRepository] for interacting with repository data.
     * @return A singleton instance of [RefreshWebPageUseCase].
     */
    @Singleton
    @Provides
    fun providesRefreshWebPageUseCase(repository: RedBrowserRepository): RefreshWebPageUseCase {
        return RefreshWebPageUseCaseImpl(repository)
    }

    /**
     * Provides an instance of [SetScrollChangeListenerUseCase] for dependency injection.
     *
     * This function supplies a singleton [SetScrollChangeListenerUseCase] implementation
     * for observing scroll position changes in a browser tab. It helps in implementing
     * dynamic UI effects, such as hiding toolbars or triggering specific actions based on
     * scroll events.
     *
     * @return A singleton instance of [SetScrollChangeListenerUseCase].
     */
    @Singleton
    @Provides
    fun providesSetScrollChangeListenerUseCase(): SetScrollChangeListenerUseCase {
        return SetScrollChangeListenerUseCaseImpl()
    }

}
