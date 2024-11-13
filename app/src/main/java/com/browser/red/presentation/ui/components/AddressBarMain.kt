package com.browser.red.presentation.ui.components

import androidx.compose.runtime.Composable
import com.browser.red.presentation.viewmodel.MainActivityViewModel
import timber.log.Timber

@Composable
fun AddressBarMain(
    mainActivityViewModel: MainActivityViewModel,
    showEditableBar:Boolean,
    onConfigurationClicked:()->Unit = {}
) {
    if(showEditableBar){
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
            onRefreshClicked = { mainActivityViewModel.refreshWebPage()},
            onConfigurationClicked = {onConfigurationClicked()}
        )
    }
}