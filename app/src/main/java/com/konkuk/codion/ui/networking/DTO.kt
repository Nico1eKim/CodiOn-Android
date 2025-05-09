package com.konkuk.codion.ui.networking

import kotlinx.serialization.Serializable

// 로그인
@Serializable
data class RequestLoginDto(
    val email: String,
    val password: String
)

@Serializable
data class ResponseLoginDto(
    val code: String,
    val message: String,
    val data: UserTokenDto? = null
)

@Serializable
data class UserTokenDto(
    val accessToken: String,
    val refreshToken: String
)