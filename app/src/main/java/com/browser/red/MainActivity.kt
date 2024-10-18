package com.browser.red

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.browser.red.presentation.ui.components.Bottombar
import com.browser.red.presentation.viewmodel.MainActivityViewModel
import com.browser.red.ui.theme.RedBrowserTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RedBrowserTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    bottomBar = { Bottombar() }
                ) { innerPadding ->
                    val modifier = Modifier
                        .padding(innerPadding)
                    RedBrowserScreen(
                        modifier = modifier
                    )
                }
            }
        }
    }
}

@Composable
fun RedBrowserScreen(
    modifier: Modifier,
    viewModel: MainActivityViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val tab = viewModel.openNewTab(WebView(context),"https://www.redbrowserapp.com")
    viewModel.configureWebView(tab)
    viewModel.setWebViewClient(tab)
    viewModel.setWebChromeClient(tab)
    viewModel.loadUrl(tab)
    AndroidView(factory = {
        viewModel.getCurrentTab()?.webView!!
    })
}

