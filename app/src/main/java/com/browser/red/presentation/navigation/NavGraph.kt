package com.browser.red.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.browser.red.presentation.ui.screens.HomeScreen
import com.browser.red.presentation.ui.screens.TabsScreen
import com.browser.red.presentation.viewmodel.TabsScreenViewModel
import com.browser.red.presentation.viewmodel.MainActivityViewModel
import kotlinx.coroutines.launch

@Composable
fun NavGraph(
    modifier: Modifier,
    navController: NavHostController,
    mainActivityViewModel: MainActivityViewModel,
    tabsScreenViewModel: TabsScreenViewModel
){
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    mainActivityViewModel.showAddressBar = currentRoute == Route.Home.name

    NavHost(navController, startDestination = Route.Home.name){
        composable(route = Route.Home.name){
            HomeScreen(modifier,mainActivityViewModel)
        }
        composable(route = Route.Tabs.name){
            TabsScreen(
                tabsScreenViewModel = tabsScreenViewModel,
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