package com.pipe.d.dev.recommendarch.accountModule.model

import com.pipe.d.dev.recommendarch.R
import com.pipe.d.dev.recommendarch.accountModule.model.domain.AccountAuth
import com.pipe.d.dev.recommendarch.common.dataAccess.local.FakeFirebaseAuth
import com.pipe.d.dev.recommendarch.common.entities.FirebaseUser
import com.pipe.d.dev.recommendarch.common.entities.MyException
import com.pipe.d.dev.recommendarch.common.model.BaseRepository
import com.pipe.d.dev.recommendarch.common.utils.Constants

class AccountRepository(private val auth: AccountAuth): BaseRepository(){
    suspend fun signOut(callback: (Boolean) -> Unit) {
        executeAction(MyException(Constants.EC_AUTH, R.string.login_auth_fail)) {
            callback(auth.signOut())
        }
    }

    suspend fun getCurrentUser(callback: (FirebaseUser?) -> Unit) {
        executeAction(MyException(Constants.EC_AUTH, R.string.login_auth_fail)) {
            callback(auth.getCurrentUser())
        }
    }
}