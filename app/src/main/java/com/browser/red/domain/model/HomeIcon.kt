package com.browser.red.domain.model

import java.util.UUID

/**
 * Data class representing a home icon on the browser's home screen.
 *
 * Each icon has a unique identifier, title, image, and content description
 * to enhance accessibility. This data model is used to store and display
 * information about home screen icons within the browser.
 *
 * @property id The unique identifier for the icon, generated by default.
 * @property title The title of the icon, displayed below the icon image.
 * @property imageId The resource ID for the icon image.
 * @property contentDescription A content description for accessibility purposes.
 */
data class HomeIcon(
    val id: UUID = UUID.randomUUID(),
    val title: String = "default",
    val imageId: Int = 0,
    val contentDescription: String = "",
    val url:String? = null
)
