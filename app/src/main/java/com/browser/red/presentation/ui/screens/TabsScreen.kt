package com.browser.red.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.browser.red.R
import com.browser.red.presentation.ui.components.IconButton
import com.browser.red.presentation.ui.components.RedBrowserTabItem
import com.browser.red.presentation.viewmodel.TabsScreenViewModel
import com.browser.red.ui.theme.Dimensions


@Composable
fun TabsScreen(
    tabsScreenViewModel: TabsScreenViewModel,
    onAddTabClicked:()->Unit = {},
    onTabSwitched:(index:Int)->Unit = {},
    onBackClicked:()->Unit = {}
){
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
    ) {
        //TopBar
        Card (
            elevation = CardDefaults.elevatedCardElevation(3.dp),
            shape = RectangleShape
        ){
            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(end = Dimensions.MediumPadding),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    painter = painterResource(id = R.drawable.baseline_keyboard_arrow_left_24),
                    contentDescription = stringResource(id = R.string.go_back)
                ){
                   onBackClicked()
                }
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(Dimensions.TopHeight)
                        .weight(1f)
                        ,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ){
                    IconButton(
                        painter = painterResource(id = R.drawable.baseline_add_circle_24),
                        contentDescription = stringResource(id=R.string.add_new_tab)
                    ){
                        onAddTabClicked()
                    }
                }
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
                items(tabsScreenViewModel.listTabs().size){index->
                    RedBrowserTabItem(
                        tab = tabsScreenViewModel.listTabs()[index],
                        onClick = {onTabSwitched(index)},
                        closable = tabsScreenViewModel.listTabs().size != 1,
                        onClose = {tab -> tabsScreenViewModel.closeTab(tab)  }
                        )
                }
            }
        }
    }
}