package com.pipe.d.dev.recommendarch.accountModule.model.domain

import com.pipe.d.dev.recommendarch.common.dataAccess.local.FakeFirebaseAuth
import com.pipe.d.dev.recommendarch.common.entities.FirebaseUser

class AccountAuth(private val auth: FakeFirebaseAuth) {
    suspend fun signOut(): Boolean = auth.signOut()

    suspend fun getCurrentUser(): FirebaseUser? = auth.getCurrentUser()
}