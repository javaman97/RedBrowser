package com.browser.red.presentation.ui.screens


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.browser.red.domain.utils.WebUtils
import com.browser.red.presentation.ui.components.RedBrowserWebView
import com.browser.red.presentation.viewmodel.MainActivityViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    mainActivityViewModel: MainActivityViewModel
) {
    val tab = mainActivityViewModel.mCurrentTab ?: return
    if (tab.url == WebUtils.DEFAULT_URL) {
        HomeDefaultScreen{
            if(it.url != null){
                val newTab = tab.copy(url = it.url)
                mainActivityViewModel.loadUrl(newTab)
            }
        }
    } else {
        RedBrowserWebView(
            tab = tab,
            modifier = modifier,
            onFocusChanged = {
                if (it.hasFocus) {
                    mainActivityViewModel.showAddressBarEditable = false
                }
            })
    }
}


