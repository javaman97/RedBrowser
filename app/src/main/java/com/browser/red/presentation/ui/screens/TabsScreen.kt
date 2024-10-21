package com.browser.red.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.browser.red.R
import com.browser.red.presentation.ui.components.IconButton
import com.browser.red.presentation.ui.components.RedBrowserTabItem
import com.browser.red.presentation.viewmodel.MainActivityViewModel
import com.browser.red.ui.theme.Dimensions

@Preview
@Composable
fun TabsScreenPreview(){
    TabsScreen(mainActivityViewModel = hiltViewModel())
}

@Composable
fun TabsScreen(mainActivityViewModel: MainActivityViewModel){
    Column(
        modifier = Modifier
            .padding(Dimensions.MediumPadding)
            .background(MaterialTheme.colorScheme.background)
    ) {
        //TopBar
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimensions.TopHeight)
                .background(MaterialTheme.colorScheme.primary)
        ){
           IconButton(
               painter = painterResource(id = R.drawable.ic_launcher_background),
               contentDescription = stringResource(id = R.string.go_back)
           )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            LazyColumn {
                items(mainActivityViewModel.tabsList){item ->
                    RedBrowserTabItem(item)
                }
            }
        }
    }
}