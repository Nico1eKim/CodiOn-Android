package com.konkuk.codion.data.service

import com.konkuk.codion.data.dto.base.BaseResponse
import com.konkuk.codion.data.dto.request.LoginRequest
import com.konkuk.codion.data.dto.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    // 로그인
    @POST("/auth/login")
    suspend fun postLogin(
        @Body request: LoginRequest
    ): BaseResponse<LoginResponse>
}