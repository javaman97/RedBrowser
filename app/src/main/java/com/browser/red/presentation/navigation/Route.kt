package com.browser.red.presentation.navigation

sealed class Route(
    val name:String,
    val title:String,
    val icon:Int
){
    object Home:Route("home_screen","Home",0)
    object Tabs:Route("tabs_screen","Tabs",0)
}