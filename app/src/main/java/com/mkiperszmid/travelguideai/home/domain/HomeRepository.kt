package com.mkiperszmid.travelguideai.home.domain

import com.mkiperszmid.travelguideai.home.domain.model.HomeFilterSettings
import com.mkiperszmid.travelguideai.home.domain.model.Place

interface HomeRepository {
    suspend fun getTravelGuide(location: String, settings: HomeFilterSettings): Result<String>

    suspend fun getPopularPlaces(): Result<List<Place>>
}
