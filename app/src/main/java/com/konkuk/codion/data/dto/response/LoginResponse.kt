package com.konkuk.codion.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val code: String,
    val message: String,
    val data: UserTokenDto? = null
)

@Serializable
data class UserTokenDto(
    val accessToken: String,
    val refreshToken: String
)
