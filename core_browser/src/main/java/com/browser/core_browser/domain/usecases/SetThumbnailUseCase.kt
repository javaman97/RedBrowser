package com.browser.core_browser.domain.usecases

import android.graphics.Bitmap
import com.browser.core_browser.domain.model.RedBrowserTab
import java.util.UUID

interface SetThumbnailUseCase {
    operator fun invoke(id:UUID,thumbnail:Bitmap)
}