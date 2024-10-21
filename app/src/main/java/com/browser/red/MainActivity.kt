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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.browser.red.presentation.ui.components.AddressBar
import com.browser.red.presentation.ui.components.BottomBarMain
import com.browser.red.presentation.ui.screens.HomeScreen
import com.browser.red.presentation.ui.screens.TabsScreen
import com.browser.red.presentation.viewmodel.MainActivityViewModel
import com.browser.red.ui.theme.RedBrowserTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    private val mainActivityViewModel: MainActivityViewModel by viewModels()
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainActivityViewModel by viewModels<MainActivityViewModel>()
        mainActivityViewModel.initialiseTab(this)
        //enableEdgeToEdge()
        setContent {
            RedBrowserTheme(darkTheme = false) {
                val scope = rememberCoroutineScope()
                val sheetState = rememberModalBottomSheetState()
                var showBottomSheet by remember { mutableStateOf(false) }
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
                                    mainActivityViewModel.getCurrentTab()?.let {
                                        mainActivityViewModel.loadUrl(it.copy(url = text))
                                    }

                                }
                            )
                            BottomBarMain(
                                mainActivityViewModel = mainActivityViewModel,
                                onTabsClicked = {
                                    showBottomSheet = !showBottomSheet
                                }
                            )
                        }

                    }
                ) { innerPadding ->
                    val modifier = Modifier
                        .padding(innerPadding)
                    App(
                        modifier = modifier,
                        mainActivityViewModel = mainActivityViewModel
                    )

                   if(showBottomSheet){
                       ModalBottomSheet(
                           sheetState = sheetState,
                           onDismissRequest = {showBottomSheet = false}
                       ) {
                           TabsScreen(mainActivityViewModel = mainActivityViewModel)
                       }
                   }
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier, mainActivityViewModel: MainActivityViewModel) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home"){
            HomeScreen(modifier = modifier,mainActivityViewModel)
        }
    }
}



