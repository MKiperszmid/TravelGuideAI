package com.mkiperszmid.travelguideai.home.data.remote

import com.mkiperszmid.travelguideai.home.data.remote.dto.ChatReponseDto
import com.mkiperszmid.travelguideai.home.data.remote.dto.ChatRequestDto
import retrofit2.http.Body
import retrofit2.http.POST

interface ChatgptApi {
    companion object {
        const val BASE_URL = "https://api.openai.com/v1/"
    }

    @POST("completions")
    suspend fun getTravelInformation(@Body body: ChatRequestDto): ChatReponseDto
}
