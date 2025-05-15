package com.konkuk.codion.data.repository

import com.konkuk.codion.data.dto.request.LoginRequest
import com.konkuk.codion.data.service.AuthService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val authService: AuthService
) {
    suspend fun emailLogin(
        email: String,
        password: String
    ) = runCatching {
        val response = authService.postLogin(
            LoginRequest(
                email = email,
                password = password
            )
        )
    }
}