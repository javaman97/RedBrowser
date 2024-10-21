package com.browser.red.presentation.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.browser.red.presentation.viewmodel.MainActivityViewModel

@Composable
fun HomeScreen(
    modifier: Modifier,
    mainActivityViewModel: MainActivityViewModel
) {
    val context = LocalContext.current
    val currentTab by mainActivityViewModel.currentTab.collectAsState()

    currentTab?.let{ tab ->
        AndroidView(
            modifier = modifier,
            factory = {
                tab.webView
            },
            update = {webView ->

            })
    }
}