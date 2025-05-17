package com.konkuk.codion.data.dto.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    @SerialName("success") val isSuccess: Boolean,
    @SerialName("code") val code: String,
    @SerialName("message") val message: String,
    @SerialName("data") val data: T?,
)