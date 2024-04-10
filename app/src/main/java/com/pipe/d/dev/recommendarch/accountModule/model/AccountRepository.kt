package com.pipe.d.dev.recommendarch.accountModule.model

import com.pipe.d.dev.recommendarch.common.dataAccess.local.FakeFirebaseAuth
import com.pipe.d.dev.recommendarch.common.entities.FirebaseUser

class AccountRepository(private val auth: FakeFirebaseAuth) {
    suspend fun signOut(): Boolean {
        return auth.signOut()
    }

    suspend fun getCurrentUser(): FirebaseUser? {
        return auth.getCurrentUser()
    }
}