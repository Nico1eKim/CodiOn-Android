package com.konkuk.codion.ui.onboarding.state

sealed class LoginState {
    data object Default : LoginState()
    data object Loading : LoginState()
    data object Success : LoginState()
    data object DifferentPassword : LoginState()
    data object NotFoundUser : LoginState()
    data object Error : LoginState()
}