package com.browser.red

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.browser.red.presentation.ui.components.AddressBar
import com.browser.red.presentation.ui.components.BottomBarMain
import com.browser.red.presentation.viewmodel.MainActivityViewModel
import com.browser.red.ui.theme.RedBrowserTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    private val mainActivityViewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            RedBrowserTheme(darkTheme = false) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    bottomBar = {
                        Column(
                            modifier = Modifier
                                .background(MaterialTheme.colorScheme.primaryContainer)
                                .padding(vertical = 4.dp)
                        ) {
                            AddressBar(
                                onGoPressed = { text ->
                                    mainActivityViewModel.getCurrentTab()?.let{
                                        mainActivityViewModel.loadUrl(it.copy(url = text))
                                    }

                                }
                            )
                            BottomBarMain(mainActivityViewModel)
                        }

                    }
                ) { innerPadding ->
                    val modifier = Modifier
                        .padding(innerPadding)
                    RedBrowserScreen(
                        modifier = modifier,
                        mainActivityViewModel = mainActivityViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun RedBrowserScreen(
    modifier: Modifier,
    mainActivityViewModel: MainActivityViewModel
) {
    val context = LocalContext.current
    val currentTab by mainActivityViewModel.currentTab.collectAsState()
    LaunchedEffect(Unit) {
        mainActivityViewModel.initialiseTab(context)
    }

    currentTab?.let{ tab ->
        AndroidView(
            modifier = modifier,
            factory = {
            tab.webView
        },
            update = {webView ->

            })
    }
}

