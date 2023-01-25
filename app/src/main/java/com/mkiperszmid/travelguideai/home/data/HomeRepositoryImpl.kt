package com.mkiperszmid.travelguideai.home.data

import com.mkiperszmid.travelguideai.home.data.remote.ChatgptApi
import com.mkiperszmid.travelguideai.home.data.remote.dto.ChatRequestDto
import com.mkiperszmid.travelguideai.home.domain.HomeRepository

class HomeRepositoryImpl(
    private val api: ChatgptApi
) : HomeRepository {
    override suspend fun getTravelGuide(location: String): Result<String> {
        return try {
            val request = ChatRequestDto(
                maxTokens = 1500,
                model = "text-davinci-003",
                "Sos una guía de viaje. Te voy a dar mi ubicación, y me vas a sugerir lugares para visitar cerca. También te voy a dar los tipo de lugares que quiero visitar. Aparte, quiero que me sugieras lugares de un tipo similar a los que te mencione que estén cerca de mi primera ubicación. Estoy en $location y quiero visitar: Museos, Restaurantes. Dame los precios de cada lugar en USD. Ordenarlos por tipo de lugar.",
                temperature = 0.7
            )
            val information = api.getTravelInformation(request)
            Result.success(information.choices.first().text)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
