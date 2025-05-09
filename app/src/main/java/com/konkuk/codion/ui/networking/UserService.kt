package com.konkuk.codion.ui.networking

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
    // 로그인
    @POST("/auth/login")
    fun postLogin(
        @Body user: RequestLoginDto
    ): Call<ResponseLoginDto>
}