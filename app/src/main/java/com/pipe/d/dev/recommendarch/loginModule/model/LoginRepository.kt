package com.pipe.d.dev.recommendarch.loginModule.model

import com.pipe.d.dev.recommendarch.R
import com.pipe.d.dev.recommendarch.common.dataAccess.local.FakeFirebaseAuth
import com.pipe.d.dev.recommendarch.common.entities.MyException
import com.pipe.d.dev.recommendarch.common.model.BaseRepository
import com.pipe.d.dev.recommendarch.common.utils.Constants
import com.pipe.d.dev.recommendarch.loginModule.model.domain.LoginAuth

class LoginRepository(private val auth: LoginAuth): BaseRepository() {
    suspend fun checkAuth(callback: (Boolean) -> Unit) {
        executeAction(MyException(Constants.EC_AUTH, R.string.login_auth_fail)) {
            callback(auth.checkAuth())
        }
    }

    suspend fun login(username: String?, pin: String?, callback: (Boolean) -> Unit){
        executeAction(MyException(Constants.EC_LOGIN, R.string.login_login_fail)) {
            callback(auth.login(username, pin))
        }
    }
}