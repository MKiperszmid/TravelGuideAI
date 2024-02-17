package com.mkiperszmid.travelguideai.home.data.remote.dto

import com.squareup.moshi.Json

data class ChatRequestDto(
    @field:Json(name = "max_tokens")
    val maxTokens: Int,
    @field:Json(name = "messages")
    val messages: List<Message>,
    @field:Json(name = "model")
    val model: String,
    @field:Json(name = "temperature")
    val temperature: Double
)