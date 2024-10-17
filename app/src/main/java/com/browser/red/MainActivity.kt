package com.browser.red

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.browser.core_browser.presentation.viewmodels.RedBrowserViewModel
import com.browser.red.ui.theme.RedBrowserTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RedBrowserTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
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
    viewModel: RedBrowserViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val tab = viewModel.openNewTab(WebView(context),"https://www.youtube.com")
    viewModel.configureWebView(tab)
    viewModel.loadUrl(tab)
    AndroidView(factory = {
        viewModel.getCurrentTab()?.webView!!
    })
}

