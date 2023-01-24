package com.mkiperszmid.travelguideai.home.presentation

import androidx.lifecycle.ViewModel
import com.mkiperszmid.travelguideai.BuildConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    init {
        println("Mi api key es: ${BuildConfig.API_KEY}")
    }
}
