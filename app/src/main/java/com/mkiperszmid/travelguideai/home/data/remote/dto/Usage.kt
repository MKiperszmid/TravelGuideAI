package com.mkiperszmid.travelguideai.home.data.remote.dto


import com.squareup.moshi.Json

data class Usage(
    @field:Json(name = "completion_tokens")
    val completionTokens: Int,
    @field:Json(name = "prompt_tokens")
    val promptTokens: Int,
    @field:Json(name = "total_tokens")
    val totalTokens: Int
)