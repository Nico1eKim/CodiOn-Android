package com.konkuk.codion.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class UserInfoResponse(
    val email: String,
    val nickname: String?,
    val personalColor: String?,
    val isSocial: Boolean?
)
