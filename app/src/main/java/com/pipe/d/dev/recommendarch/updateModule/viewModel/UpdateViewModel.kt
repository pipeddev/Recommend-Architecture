package com.pipe.d.dev.recommendarch.updateModule.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pipe.d.dev.recommendarch.R
import com.pipe.d.dev.recommendarch.common.entities.Wine
import com.pipe.d.dev.recommendarch.common.viewModel.BaseViewModel
import com.pipe.d.dev.recommendarch.updateModule.model.UpdateRepository

class UpdateViewModel(private val repository: UpdateRepository): BaseViewModel() {
    private val _wine = MutableLiveData<Wine>()
    val wine: LiveData<Wine> = _wine

    fun requestWine(id: Double) {
        executeAction {
            repository.requestWine(id) {wine ->
                _wine.postValue(wine)
            }
        }
    }

    fun updateWine(newRating: String) {
        executeAction {
            repository.updateWine(wine.value, newRating) {
                setSnackbarMsg(R.string.room_save_success)
            }
        }
    }

    override fun onPause() = clearValues()
}