package com.konkuk.codion.data.dto.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class BaseResponse<T>(
    @Transient val isSuccess: Boolean = false,  // TODO: 서버에서 isSuccess 반환하는 걸로 수정된다면 이 부분 코드 삭제하기
//    @SerialName("isSuccess") val isSuccess: Boolean,  // TODO: 서버에서 isSuccess 반환하는 걸로 수정된다면 이 부분 코드 활성화하기
    @SerialName("code") val code: String,
    @SerialName("message") val message: String,
    @SerialName("data") val data: T?,
) {  // TODO: 서버에서 isSuccess 반환하는 걸로 수정된다면 이 아래 부분 코드 삭제하기
    val isSuccessLike: Boolean
        get() = code in successCodes

    companion object {
        val successCodes = setOf(
            "COMMENT_001", "COMMENT_002", "COMMENT_003",
            "MYPAGE_001", "MYPAGE_002", "MYPAGE_003", "MYPAGE_004",
            "COORD_001", "COORD_002", "COORD_003", "COORD_004",
            "CLOSET_001", "CLOSET_002", "CLOSET_003", "CLOSET_004", "CLOSET_005", "CLOSET_006",
            "AUTH_001", "AUTH_002", "AUTH_003", "AUTH_004"
        )
    }
}