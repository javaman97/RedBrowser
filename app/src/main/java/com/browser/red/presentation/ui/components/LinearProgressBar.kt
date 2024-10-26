package com.browser.red.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.browser.red.presentation.viewmodel.MainActivityViewModel

@Composable
fun LinearProgressBar(onPageStarted:Boolean,progress:Float) {
    if(onPageStarted){
        LinearProgressIndicator(
            progress = {progress},
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(MaterialTheme.colorScheme.primary)
        )
    }
}