package com.mkiperszmid.travelguideai.home.domain

interface HomeRepository {
    suspend fun getTravelGuide(location: String): Result<String>
}
