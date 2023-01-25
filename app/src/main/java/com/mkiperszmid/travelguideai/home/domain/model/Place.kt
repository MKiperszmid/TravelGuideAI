package com.mkiperszmid.travelguideai.home.domain.model

data class Place(
    val country: String,
    val city: String,
    val region: Region,
    val image: String
)

enum class Region {
    TODAS,
    AMERICA,
    ASIA,
    EUROPA,
    OCEANIA
}
