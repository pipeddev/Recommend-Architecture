package com.pipe.d.dev.recommendarch.loginModule.model.domain

import com.pipe.d.dev.recommendarch.R
import com.pipe.d.dev.recommendarch.common.dataAccess.local.FakeFirebaseAuth
import com.pipe.d.dev.recommendarch.common.entities.MyException
import com.pipe.d.dev.recommendarch.common.model.BaseRepository
import com.pipe.d.dev.recommendarch.common.utils.Constants
import javax.security.auth.callback.Callback

class LoginAuth(private val auth: FakeFirebaseAuth) {
    suspend fun checkAuth(): Boolean = auth.isValidAuth()

    suspend fun login(username: String?, pin: String?): Boolean {
        if (!username.isNullOrEmpty() && !pin.isNullOrEmpty())
            return auth.login(username, pin)

        return false
    }
}