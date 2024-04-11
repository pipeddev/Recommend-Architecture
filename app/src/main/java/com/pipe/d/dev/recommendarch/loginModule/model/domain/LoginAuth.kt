package com.pipe.d.dev.recommendarch.loginModule.model.domain

import com.pipe.d.dev.recommendarch.common.dataAccess.local.FakeFirebaseAuth

class LoginAuth(private val auth: FakeFirebaseAuth) {
    suspend fun checkAuth(): Boolean = auth.isValidAuth()

    suspend fun login(username: String?, pin: String?): Boolean {
        if (!username.isNullOrEmpty() && !pin.isNullOrEmpty()){
            val result = auth.login(username, pin)
            return if (result) true else throw Exception()
        }

        throw Exception()
    }
}