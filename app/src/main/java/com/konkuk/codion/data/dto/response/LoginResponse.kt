package com.konkuk.codion.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val accessToken: String,
    val refreshToken: String,
    val user: UserInfoResponse?
)
