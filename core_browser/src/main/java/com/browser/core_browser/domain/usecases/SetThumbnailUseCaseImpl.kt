package com.browser.core_browser.domain.usecases

import android.graphics.Bitmap
import com.browser.core_browser.domain.manager.TabManager
import com.browser.core_browser.domain.model.RedBrowserTab
import java.util.UUID

internal class SetThumbnailUseCaseImpl(private val tabManager: TabManager):SetThumbnailUseCase {
    override fun invoke(id: UUID, thumbnail: Bitmap) {
        tabManager.setThumbnail(id,thumbnail)
    }

}