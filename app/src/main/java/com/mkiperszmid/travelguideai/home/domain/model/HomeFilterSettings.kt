package com.mkiperszmid.travelguideai.home.domain.model

data class HomeFilterSettings(
    val people: Int = 1,
    val restaurant: Boolean = false,
    val museums: Boolean = false
)
