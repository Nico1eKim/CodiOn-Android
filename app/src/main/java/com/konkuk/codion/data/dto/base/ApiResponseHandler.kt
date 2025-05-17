package com.konkuk.codion.data.dto.base

fun <T> BaseResponse<T>.handleBaseResponse(): Result<T?> =
    if (isSuccess) {
        Result.success(data)
    } else {
        Result.failure(
            CodiOnApiFailureException(
                code = code,
                message = message
            )
        )
    }

class CodiOnApiFailureException(
    private val code: String? = null,
    override val message: String? = null
) : Exception(
    "CodiOn API failure: code = $code, message = $message"
)