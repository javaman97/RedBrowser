package com.browser.core_browser.Utils

import android.graphics.Bitmap
import android.view.View
import android.webkit.WebView
import androidx.core.view.drawToBitmap

 fun View.captureImage(): Bitmap {
    val originalBitmap = this.drawToBitmap()
    val scaledWidth = (originalBitmap.width * 0.5).toInt()
    val scaledHeight = (originalBitmap.height * 0.5).toInt()
    return Bitmap.createScaledBitmap(originalBitmap, scaledWidth, scaledHeight, true)
}