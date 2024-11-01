package com.browser.red.presentation.ui.components

import androidx.compose.runtime.Composable
import com.browser.red.presentation.viewmodel.MainActivityViewModel

@Composable
fun AddressBarMain(
    mainActivityViewModel: MainActivityViewModel
) {
    if(mainActivityViewModel.showAddressBarEditable){
        AddressBarEditable(
            currentUrl = mainActivityViewModel.currentUrl,
            onGoPressed = { text ->
                mainActivityViewModel.getCurrentTab()?.let { currentTab ->
                    currentTab.url = text
                    mainActivityViewModel.loadUrl(currentTab)
                }

            }
        )
    } else {
        AddressBarSimple(
            title = mainActivityViewModel.pageTitle,
            onAddressClicked = { mainActivityViewModel.showAddressBarEditable = true},
            onRefreshClicked = { mainActivityViewModel.refreshWebPage()}
        )
    }
}