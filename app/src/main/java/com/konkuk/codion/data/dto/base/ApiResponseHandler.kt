package com.konkuk.codion.data.dto.base

fun <T> BaseResponse<T>.handleBaseResponse(): Result<T?> =
    if (isSuccessLike) {  // TODO: 서버에서 isSuccess 반환하는 걸로 수정된다면 이 부분 코드도 if (isSuccess)로 수정
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