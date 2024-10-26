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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
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
                    .background(MaterialTheme.colorScheme.primaryContainer),
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
                        imageVector = Icons.Default.Add,
                        contentDescription = stringResource(id=R.string.add_new_tab),
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
                items(list.size){index->
                    RedBrowserTabItem(list[index]){
                        onTabSwitched(index)
                    }
                }
            }
        }
    }
}