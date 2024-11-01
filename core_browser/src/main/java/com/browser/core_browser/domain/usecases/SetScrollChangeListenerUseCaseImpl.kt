package com.browser.core_browser.domain.usecases

import android.view.View.OnScrollChangeListener
import com.browser.core_browser.domain.model.RedBrowserTab

internal class SetScrollChangeListenerUseCaseImpl:SetScrollChangeListenerUseCase {
    override fun invoke(tab: RedBrowserTab, listener: OnScrollChangeListener) {
        tab.webView.setOnScrollChangeListener(listener)
    }

}