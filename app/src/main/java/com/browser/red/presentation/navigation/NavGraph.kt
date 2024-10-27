package com.browser.red.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.browser.red.presentation.ui.screens.HomeScreen
import com.browser.red.presentation.ui.screens.TabsScreen
import com.browser.red.presentation.viewmodel.MainActivityViewModel
import kotlinx.coroutines.launch

@Composable
fun NavGraph(modifier:Modifier, navController: NavHostController, mainActivityViewModel: MainActivityViewModel){
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    NavHost(navController, startDestination = "home_screen"){
        composable(route = "home_screen"){
            HomeScreen(modifier,mainActivityViewModel)
        }
        composable(route = "tabs_screen"){
            TabsScreen(
                list = mainActivityViewModel.listTabs(),
                onAddTabClicked = {
                    scope.launch {
                        mainActivityViewModel.addTab(context = context)
                        navController.navigateUp()
                    }

                },
                onTabSwitched = { index ->
                    scope.launch {
                        navController.navigateUp()
                        mainActivityViewModel.switchToTab(index)
                    }
                },
                onBackClicked = { navController.navigateUp()}
            )
        }
    }
}