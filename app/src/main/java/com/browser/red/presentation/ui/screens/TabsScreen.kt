package com.browser.red.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.browser.core_browser.domain.model.RedBrowserTab
import com.browser.red.R
import com.browser.red.presentation.ui.components.IconButton
import com.browser.red.presentation.ui.components.RedBrowserTabItem
import com.browser.red.presentation.viewmodel.MainActivityViewModel
import com.browser.red.ui.theme.Dimensions


@Composable
fun TabsScreen(
    list: List<RedBrowserTab>,
    onAddTabClicked:()->Unit = {},
    onTabSwitched:(index:Int)->Unit = {}
){
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
                .background(MaterialTheme.colorScheme.primary),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ){
            IconButton(
                imageVector = Icons.Default.Add,
                contentDescription = stringResource(id=R.string.add_new_tab),
                tint = Color.White
            ){
                onAddTabClicked()
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                items(list.size){index->
                    RedBrowserTabItem(list[index]){
                        onTabSwitched(index)
                    }
                }
            }
        }
    }
}