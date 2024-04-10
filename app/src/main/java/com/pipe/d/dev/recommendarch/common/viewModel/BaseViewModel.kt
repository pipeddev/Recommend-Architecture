package com.pipe.d.dev.recommendarch.common.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pipe.d.dev.recommendarch.common.entities.MyException
import com.pipe.d.dev.recommendarch.common.utils.Constants
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class BaseViewModel: ViewModel() {
    private val _inProgress = MutableLiveData<Boolean>()
    val inProgress: LiveData<Boolean> = _inProgress

    private val _snackBarMsg = MutableLiveData<Int?>()
    val snackBarMsg: LiveData<Int?> = _snackBarMsg

    protected fun setInProgress(value: Boolean) {
        _inProgress.postValue(value)
    }

    protected fun setSnackbarMsg(value: Int?) {
        _snackBarMsg.postValue(value)
    }

    open fun onPause() {

    }

    protected fun clearValues() {
        setSnackbarMsg(null)
    }

    protected fun executeAction(block: suspend () -> Unit): Job {
        return viewModelScope.launch {
            _inProgress.value = Constants.SHOW
            try {
                block()
            } catch (ex: MyException){
                _snackBarMsg.value = ex.resMsg
            } finally {
                _inProgress.value = Constants.HIDE
            }
        }
    }
}