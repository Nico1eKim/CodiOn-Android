package com.konkuk.codion.data.service

import com.konkuk.codion.data.dto.request.LoginRequest
import com.konkuk.codion.data.dto.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    // 로그인
    @POST("/auth/login")
    fun postLogin(
        @Body user: LoginRequest
    ): Call<LoginResponse>
}