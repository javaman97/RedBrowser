package com.browser.core_browser.di


import com.browser.core_browser.domain.manager.DefaultTabManager
import com.browser.core_browser.domain.manager.TabManager
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ManagerModule {

    @Provides
    @Singleton
     fun providesTabManager():TabManager{
         return DefaultTabManager()
     }
}
