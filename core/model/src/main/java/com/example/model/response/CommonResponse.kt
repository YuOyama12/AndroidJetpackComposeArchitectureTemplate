package com.example.model.response

import kotlinx.serialization.Serializable

@Serializable
data class CommonResponse(
    val message: String? = null
)
