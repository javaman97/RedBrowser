package com.browser.core_browser.domain.usecases

import android.view.View.OnScrollChangeListener
import com.browser.core_browser.domain.model.RedBrowserTab

interface SetScrollChangeListenerUseCase {
    operator fun invoke(tab:RedBrowserTab,listener: OnScrollChangeListener)
}