package com.browser.core_browser.domain.usecases

import android.graphics.Bitmap
import java.util.UUID

/**
 * A use case interface for setting a thumbnail image for a specified browser tab.
 *
 * This interface defines a contract for updating the thumbnail associated with a
 * specific tab, which can be used for preview purposes in a tab management UI.
 */
interface SetThumbnailUseCase {

    /**
     * Sets the thumbnail image for a browser tab identified by its unique ID.
     *
     * This operator function allows easy invocation using `invoke`, making it possible
     * to call the use case like a function. It accepts a unique identifier for the tab
     * and the bitmap image to be set as its thumbnail, helping to provide a preview of
     * the tab's contents.
     *
     * @param id The [UUID] that uniquely identifies the browser tab.
     * @param thumbnail The [Bitmap] image to be used as the thumbnail for the tab.
     */
    operator fun invoke(id: UUID, thumbnail: Bitmap)
}
