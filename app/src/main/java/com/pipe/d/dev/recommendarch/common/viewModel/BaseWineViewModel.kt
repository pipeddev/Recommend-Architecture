package com.pipe.d.dev.recommendarch.common.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pipe.d.dev.recommendarch.common.entities.Wine

open class BaseWineViewModel: BaseViewModel() {

    private val _wines = MutableLiveData<List<Wine>>()
    val wines: LiveData<List<Wine>> = _wines

    protected fun setWines(value: List<Wine>) {
        _wines.postValue(value)
    }

    open fun getAllWines() {}
}