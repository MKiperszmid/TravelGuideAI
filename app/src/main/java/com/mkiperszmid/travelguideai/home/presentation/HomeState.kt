package com.mkiperszmid.travelguideai.home.presentation

import com.mkiperszmid.travelguideai.home.domain.HomeFilterSettings

data class HomeState(
    val searchText: String = "",
    val showDialog: Boolean = false,
    val filterSettings: HomeFilterSettings = HomeFilterSettings(),
    val filterSettingsBackup: HomeFilterSettings = filterSettings,
    val chatReply: String? = null
)
