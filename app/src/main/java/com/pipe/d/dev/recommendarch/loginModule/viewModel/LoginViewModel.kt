package com.pipe.d.dev.recommendarch.loginModule.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pipe.d.dev.recommendarch.common.entities.FirebaseUser
import com.pipe.d.dev.recommendarch.common.entities.MyException
import com.pipe.d.dev.recommendarch.common.utils.Constants
import com.pipe.d.dev.recommendarch.loginModule.model.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: LoginRepository): ViewModel() {
    private val _inProgress = MutableLiveData<Boolean>()
    val inProgress: LiveData<Boolean> = _inProgress

    private val _snackBarMsg = MutableLiveData<Int>()
    val snackBarMsg: LiveData<Int> = _snackBarMsg

    private val _isValidAuth = MutableLiveData<Boolean>()
    val isValidAuth: LiveData<Boolean> = _isValidAuth

    init {
        checkAuth()
    }

    private fun checkAuth() {
        viewModelScope.launch {
            _inProgress.value = Constants.SHOW
            try {
                _isValidAuth.value = repository.checkAuth()
            } finally {
                _inProgress.value = Constants.HIDE
            }
        }
    }

    fun login(username: String, pin: String) {
        viewModelScope.launch {
            _inProgress.value = Constants.SHOW
            try {
                _isValidAuth.value = repository.login(username, pin)
            } catch (ex: MyException){
                _snackBarMsg.value = ex.resMsg
            } finally {
                _inProgress.value = Constants.HIDE
            }
        }
    }
}