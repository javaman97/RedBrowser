package com.browser.red.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.browser.red.R
import com.browser.red.ui.theme.Dimensions

@Preview()
@Composable
fun PrivacyAndSecurityBottomSheetPreview(){
    PrivacyAndSecurityBottomSheet(true)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrivacyAndSecurityBottomSheet(
    showBottomSheet:Boolean,
    onDismissRequest:()->Unit={},
    onConnectionStatusClicked:()->Unit={},
    onSecurityAndPrivacyClicked:()->Unit = {},
    onPermissionsClicked:()->Unit = {},
    onLastVisitedClicked:()->Unit={}
    ){
   if(showBottomSheet){
       ModalBottomSheet(
           onDismissRequest = {onDismissRequest()}
       ) {
           Column(
               modifier = Modifier
                   .background(MaterialTheme.colorScheme.primaryContainer)
                   .padding(horizontal = Dimensions.MediumPadding)
           ) {
               //Connection Status
               Row (
                   modifier = Modifier
                       .padding(vertical = Dimensions.MediumPadding),
                   verticalAlignment = Alignment.CenterVertically,
                   horizontalArrangement = Arrangement.spacedBy(Dimensions.MediumPadding)
               ){
                   Icon(
                       painter = painterResource(R.drawable.round_lock_outline_24),
                       contentDescription = ""
                   )
                   Text(
                       modifier = Modifier
                           .weight(1f),
                       text = stringResource(R.string.connection_security_status_secure)
                   )
                   Icon(
                       modifier = Modifier.clickable { onConnectionStatusClicked() },
                       painter = painterResource(R.drawable.baseline_keyboard_arrow_right_24),
                       contentDescription =  stringResource(R.string.connection_security_status_secure)
                   )
               }

               HorizontalDivider(
                   modifier = Modifier.padding(horizontal = Dimensions.MediumPadding),
                   thickness = 1.dp,
                   color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f) // Use a subtle color from the theme
               )

               //Privacy and security
               Row (
                   modifier = Modifier
                       .padding(vertical = Dimensions.MediumPadding),
                   verticalAlignment = Alignment.CenterVertically,
                   horizontalArrangement = Arrangement.spacedBy(Dimensions.MediumPadding)
               ){
                   Icon(
                       painter = painterResource(R.drawable.baseline_security_24),
                       contentDescription = ""
                   )
                   Text(
                       modifier = Modifier
                           .weight(1f),
                       text = stringResource(R.string.privacy_and_security)
                   )
                   Icon(
                       modifier = Modifier.clickable { onSecurityAndPrivacyClicked() },
                       painter = painterResource(R.drawable.baseline_keyboard_arrow_right_24),
                       contentDescription = stringResource(R.string.privacy_and_security)
                   )
               }


               HorizontalDivider(
                   modifier = Modifier.padding(horizontal = Dimensions.MediumPadding),
                   thickness = 1.dp,
                   color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f) // Use a subtle color from the theme
               )

               //Permissions
               Row (
                   modifier = Modifier
                       .padding(vertical = Dimensions.MediumPadding),
                   verticalAlignment = Alignment.CenterVertically,
                   horizontalArrangement = Arrangement.spacedBy(Dimensions.MediumPadding)
               ){
                   Icon(
                       painter = painterResource(R.drawable.baseline_settings_suggest_24),
                       contentDescription = ""
                   )
                   Text(
                       modifier = Modifier
                           .weight(1f),
                       text = stringResource(R.string.permissions)
                   )
                   Icon(
                       modifier = Modifier.clickable { onPermissionsClicked() },
                       painter = painterResource(R.drawable.baseline_keyboard_arrow_right_24),
                       contentDescription = stringResource(R.string.permissions)
                   )
               }
               HorizontalDivider(
                   modifier = Modifier.padding(horizontal = Dimensions.MediumPadding),
                   thickness = 1.dp,
                   color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f) // Use a subtle color from the theme
               )

               //Last visited
               Row (
                   modifier = Modifier
                       .padding(vertical = Dimensions.MediumPadding),
                   verticalAlignment = Alignment.CenterVertically,
                   horizontalArrangement = Arrangement.spacedBy(Dimensions.MediumPadding)
               ){
                   Icon(
                       painter = painterResource(R.drawable.baseline_visibility_24),
                       contentDescription = ""
                   )
                   Text(
                       modifier = Modifier
                           .weight(1f),
                       text = stringResource(R.string.last_visited)
                   )
                   Icon(
                       modifier = Modifier.clickable { onLastVisitedClicked() },
                       painter = painterResource(R.drawable.baseline_keyboard_arrow_right_24),
                       contentDescription = stringResource(R.string.last_visited)
                   )
               }
           }
       }
   }
}