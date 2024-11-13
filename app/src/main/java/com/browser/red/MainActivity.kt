package com.browser.red

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.browser.red.presentation.ui.components.BottomBarMain
import com.browser.red.presentation.navigation.NavGraph
import com.browser.red.presentation.navigation.Route
import com.browser.red.presentation.ui.components.AddressBarMain
import com.browser.red.presentation.ui.components.LinearProgressBar
import com.browser.red.presentation.ui.components.PrivacyAndSecurityBottomSheet
import com.browser.red.presentation.viewmodel.TabsScreenViewModel
import com.browser.red.presentation.viewmodel.MainActivityViewModel
import com.browser.red.ui.theme.RedBrowserTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var mContext: Context
    private val mainActivityViewModel: MainActivityViewModel by viewModels()
    private val tabsScreenViewModel: TabsScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        val mainActivityViewModel by viewModels<MainActivityViewModel>()
        mainActivityViewModel.addTab(this)
        //enableEdgeToEdge()
        setContent {
            RedBrowserTheme(darkTheme = false) {
                val scope = rememberCoroutineScope()
                val navController = rememberNavController()
                var showPrivacyAndSecurityBottomSheet by remember { mutableStateOf(false) }

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    bottomBar = {
                        Column(
                            modifier = Modifier
                                .background(MaterialTheme.colorScheme.primaryContainer)
                                .padding(vertical = 4.dp)
                        ) {
                            LinearProgressBar(
                                onPageStarted = mainActivityViewModel.onPageStarted,
                                progress =  mainActivityViewModel.pageProgress)

                            //AddressBar
                            AnimatedVisibility(
                                visible = mainActivityViewModel.showAddressBar,
                                enter = slideInHorizontally(
                                    initialOffsetX = { it }
                                ),
                                exit = slideOutHorizontally(
                                    targetOffsetX = { it }
                                )
                            ){
                                AddressBarMain(
                                    mainActivityViewModel = mainActivityViewModel,
                                    showEditableBar = mainActivityViewModel.showAddressBarEditable,
                                    onConfigurationClicked = { showPrivacyAndSecurityBottomSheet = true}
                                    )
                            }

                            //BottomBar
                            AnimatedVisibility(
                                visible = mainActivityViewModel.showBottomBar,
                                enter = slideInHorizontally(
                                    initialOffsetX = { -it }
                                ),
                                exit = slideOutHorizontally(
                                    targetOffsetX = { -it }
                                )
                            ) {
                                BottomBarMain(
                                    mainActivityViewModel = mainActivityViewModel,
                                    tabsScreenViewModel = tabsScreenViewModel,
                                    onTabsClicked = {
                                        scope.launch {
                                            mainActivityViewModel.captureCurrentTabThumbnail()
                                            navController.navigate(Route.Tabs.name)
                                        }
                                    }
                                )
                            }
                        }

                    }
                ) { innerPadding ->
                    val modifier = Modifier
                        .padding(innerPadding)
                    App(
                        modifier = modifier,
                        navController=navController,
                        mainActivityViewModel = mainActivityViewModel,
                        tabsScreenViewModel = tabsScreenViewModel
                    )

                    PrivacyAndSecurityBottomSheet(
                        showBottomSheet = showPrivacyAndSecurityBottomSheet,
                        onDismissRequest = {showPrivacyAndSecurityBottomSheet = false}
                        )
                }
            }
        }
    }
}

@Composable
fun App(
    modifier: Modifier,
    navController: NavHostController,
    mainActivityViewModel: MainActivityViewModel,
    tabsScreenViewModel: TabsScreenViewModel
) {
  NavGraph(
      modifier = modifier,
      navController = navController ,
      mainActivityViewModel = mainActivityViewModel,
      tabsScreenViewModel = tabsScreenViewModel
  )
}



