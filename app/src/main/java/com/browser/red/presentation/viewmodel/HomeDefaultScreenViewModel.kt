package com.browser.red.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.browser.red.R
import com.browser.red.domain.HomeIconRepository
import com.browser.red.domain.model.HomeIcon
import com.browser.red.domain.usecases.homeicon.AddHomeIconUseCase
import com.browser.red.domain.usecases.homeicon.GetHomeIconUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeDefaultScreenViewModel @Inject constructor(
    private val addHomeIconUseCase: AddHomeIconUseCase,
    private val getHomeIconUseCase: GetHomeIconUseCase
):ViewModel() {
    init {
        initialiseIcons()
    }
    fun initialiseIcons() = viewModelScope.launch(Dispatchers.IO){
        addHomeIconUseCase(HomeIcon(imageId = R.drawable.google_svgrepo_com, url = "https://www.google.com"))
        addHomeIconUseCase(HomeIcon(imageId = R.drawable.youtube_color_svgrepo_com, url = "https://www.youtube.com"))
        addHomeIconUseCase(HomeIcon(imageId = R.drawable.facebook_color_svgrepo_com, url = "https://www.facebook.com"))
        addHomeIconUseCase(HomeIcon(imageId = R.drawable.twitter_color_svgrepo_com, url = "https://www.twitter.com"))
        addHomeIconUseCase(HomeIcon(imageId = R.drawable.instagram_1_svgrepo_com, url = "https://www.instagram.com"))
        addHomeIconUseCase(HomeIcon(imageId = R.drawable.tiktok_svgrepo_com, url = "https://www.tiktok.com"))
        addHomeIconUseCase(HomeIcon(imageId = R.drawable.reddit_color_svgrepo_com,url = "https://www.reddit.com"))
        addHomeIconUseCase(HomeIcon(imageId = R.drawable.linkedin_svgrepo_com, url = "https://www.linkedin.com"))
    }

    fun getIcons():List<HomeIcon>{
        return getHomeIconUseCase()
    }
}