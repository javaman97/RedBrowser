package com.browser.red.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.browser.red.R
@Preview
@Composable
fun AddressBarEditable(
    currentUrl:String = "",
    onTextChanged:(newText:String)->Unit={},
    onGoPressed:(text:String)->Unit={},
    onClearClicked:()->Unit = {},
    onFocusChanged:(FocusState) -> Unit = {}
    ){
    val keyboardController = LocalSoftwareKeyboardController.current
    var txtSearch by remember { mutableStateOf(currentUrl) }
    val showClearIcon by remember { mutableStateOf(if (txtSearch.isNotEmpty()) true else false) }
    Card (elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .onFocusChanged { onFocusChanged(it) }
    ){
        TextField(
            modifier = Modifier
                .fillMaxWidth()
            ,
            value = txtSearch,
            onValueChange = {
                txtSearch = it
                onTextChanged(txtSearch)
            },
            singleLine = true,
            placeholder = { Text(stringResource(id = R.string.type_any_thing)) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
            ),
            leadingIcon = {
                Icon(
                    modifier = Modifier
                        .size(28.dp),
                    imageVector = Icons.Default.Search,
                    contentDescription =  "Search"
                )
            },
            trailingIcon = {
                if(showClearIcon){
                    Icon(
                        modifier = Modifier
                            .size(28.dp)
                            .clickable { txtSearch = "" },
                        imageVector = Icons.Default.Close,
                        contentDescription =  "Search"
                    )
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Go
            ),
            keyboardActions = KeyboardActions(
                onGo = {
                    onGoPressed(txtSearch)
                    keyboardController?.hide()
                }
            )

        )
    }
}