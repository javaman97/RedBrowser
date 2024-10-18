package com.browser.red.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.browser.red.R

@Composable
fun Bottombar() {
    val iconModifier = Modifier.size(24.dp)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Icon(
            modifier = iconModifier,
            painter = painterResource(id = R.drawable.baseline_keyboard_arrow_left_24),
            contentDescription = stringResource(id = R.string.go_back)
        )
        Icon(
            modifier = iconModifier,
            painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
            contentDescription = stringResource(id = R.string.go_forward)
        )
        Icon(
            modifier = iconModifier,
            painter = painterResource(id = R.drawable.baseline_local_fire_department_24),
            contentDescription = stringResource(id = R.string.clear_everything)
        )
        Icon(
            modifier = iconModifier,
            painter = painterResource(id = R.drawable.baseline_web_asset_24),
            contentDescription = stringResource(id = R.string.opened_tabs_count)
        )

        Icon(
            modifier = iconModifier,
            painter = painterResource(id = R.drawable.baseline_table_rows_24),
            contentDescription = stringResource(id = R.string.more_bottombar)
        )
    }
}