package com.browser.red.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.browser.red.R
import com.browser.red.presentation.viewmodel.MainActivityViewModel
import com.browser.red.ui.theme.Gray400
import kotlinx.coroutines.launch
import timber.log.Timber


@Composable
fun BottomBarMain(
    mainActivityViewModel: MainActivityViewModel,
    onTabsClicked: () -> Unit = {}
) {
    val iconSizeDp = DpSize(28.dp, 28.dp)
    val scope = rememberCoroutineScope()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(38.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if(mainActivityViewModel.canGoBack){
            IconButton(
                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_left_24),
                contentDescription = stringResource(id = R.string.go_back)
            ){
               scope.launch {
                   mainActivityViewModel.goBack()
               }
            }
        } else {
            IconButton(
                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_left_24),
                contentDescription = stringResource(id = R.string.go_back),
                tint = Gray400
            )
        }

        if(mainActivityViewModel.canGoForward){
            IconButton(
                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                contentDescription = stringResource(id = R.string.go_forward)
            ){
                scope.launch {
                    mainActivityViewModel.goForward()
                }
            }
        } else {
            IconButton(
                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                contentDescription = stringResource(id = R.string.go_forward),
                tint = Gray400
            )
        }

        IconButton(
            painter = painterResource(id = R.drawable.baseline_local_fire_department_24),
            contentDescription = stringResource(id = R.string.clear_everything)
        )
        IconButton(
            painter = painterResource(id = R.drawable.baseline_web_asset_24),
            contentDescription = stringResource(id = R.string.opened_tabs_count),
            caption = mainActivityViewModel.listTabs().count().toString()
        ) {
            onTabsClicked()
        }

        IconButton(
            painter = painterResource(id = R.drawable.baseline_table_rows_24),
            contentDescription = stringResource(id = R.string.more_bottombar)
        )
    }
}