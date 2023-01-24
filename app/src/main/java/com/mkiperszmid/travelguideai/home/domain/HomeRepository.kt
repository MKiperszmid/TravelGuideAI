package com.mkiperszmid.travelguideai.home.domain

interface HomeRepository {
    suspend fun getTravelGuide(): Result<String>
}
