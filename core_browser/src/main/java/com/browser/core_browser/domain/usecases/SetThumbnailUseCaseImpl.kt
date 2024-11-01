package com.browser.core_browser.domain.usecases

import android.graphics.Bitmap
import com.browser.core_browser.domain.manager.TabManager
import com.browser.core_browser.domain.model.RedBrowserTab
import java.util.UUID

/**
 * Implementation of the [SetThumbnailUseCase] interface, responsible for setting a thumbnail
 * image for a specified browser tab.
 *
 * This class interacts with the [TabManager] to update the thumbnail associated with a given
 * tab ID, allowing for efficient tab preview management within the browser.
 *
 * @property tabManager The [TabManager] instance used to manage and update tab thumbnails.
 */
internal class SetThumbnailUseCaseImpl(private val tabManager: TabManager) : SetThumbnailUseCase {

    /**
     * Sets the thumbnail image for a browser tab identified by its unique ID.
     *
     * This function overrides the `invoke` operator function in the [SetThumbnailUseCase]
     * interface. It uses the [TabManager] to update the thumbnail associated with the specified
     * tab ID, facilitating quick access to a preview of the tab's content.
     *
     * @param id The [UUID] that uniquely identifies the browser tab.
     * @param thumbnail The [Bitmap] image to be used as the thumbnail for the tab.
     */
    override fun invoke(id: UUID, thumbnail: Bitmap) {
        tabManager.setThumbnail(id, thumbnail)
    }
}
