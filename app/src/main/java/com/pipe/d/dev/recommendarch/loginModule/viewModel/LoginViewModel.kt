package com.pipe.d.dev.recommendarch.loginModule.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pipe.d.dev.recommendarch.common.entities.FirebaseUser
import com.pipe.d.dev.recommendarch.common.entities.MyException
import com.pipe.d.dev.recommendarch.common.utils.Constants
import com.pipe.d.dev.recommendarch.common.viewModel.BaseViewModel
import com.pipe.d.dev.recommendarch.loginModule.model.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: LoginRepository): BaseViewModel() {
    val username = MutableLiveData("cursoant")
    val pin = MutableLiveData("1234")


    private val _isValidAuth = MutableLiveData<Boolean>()
    val isValidAuth: LiveData<Boolean> = _isValidAuth

    init {
        checkAuth()
    }

    private fun checkAuth() {
        executeAction {
            repository.checkAuth() { result ->
                _isValidAuth.value = result
            }
        }
    }

    fun login() {
        executeAction {
            repository.login(username.value, pin.value) { result ->
                _isValidAuth.value = result
            }
        }
    }

    override fun onPause() = clearValues()
}