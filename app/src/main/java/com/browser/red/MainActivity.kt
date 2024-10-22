package com.browser.red

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var mContext: Context
    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        val mainActivityViewModel by viewModels<MainActivityViewModel>()
        mainActivityViewModel.addTab(this)
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
                                        it.url = text
                                        mainActivityViewModel.loadUrl(it)
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

                    if (showBottomSheet) {
                        ModalBottomSheet(
                            sheetState = sheetState,
                            onDismissRequest = { showBottomSheet = false }
                        ) {
                            TabsScreen(
                                list = mainActivityViewModel.listTabs(),
                                onAddTabClicked = {
                                    mainActivityViewModel.addTab(
                                        context = mContext,
                                        url = "http://www.google.com"
                                    )
                                },
                                onTabSwitched = { index ->
                                    scope.launch {
                                        showBottomSheet = false
                                        mainActivityViewModel.switchToTab(index)
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier, mainActivityViewModel: MainActivityViewModel) {
    HomeScreen(modifier = modifier, mainActivityViewModel.mCurrentTab)
}



