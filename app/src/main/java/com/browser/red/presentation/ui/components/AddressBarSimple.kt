package com.browser.red.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.browser.red.R
import com.browser.red.ui.theme.Dimensions
import com.browser.red.ui.theme.Green800
import com.browser.red.ui.theme.Typography

@Preview
@Composable
fun AddressBarSimple(
    title:String = "",
    onAddressClicked:()->Unit = {},
    onRefreshClicked:()->Unit = {}
    ){
    val iconSize = DpSize(width = 28.dp, height = 28.dp)
    Card (elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimensions.MediumPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(iconSize),
                painter = painterResource(id = R.drawable.controls_alt_svgrepo_com),
                contentDescription = stringResource(id = R.string.controls_settings)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clickable {
                        onAddressClicked()
                    }
                ,
                text = title,
                style = Typography.labelMedium,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Image(
                modifier = Modifier
                    .size(iconSize)
                    .clickable { onRefreshClicked() }
                ,
                painter = painterResource(id = R.drawable.baseline_refresh_24),
                contentDescription = stringResource(id = R.string.controls_settings),
                colorFilter = ColorFilter.tint(Green800)
            )
        }
    }
}