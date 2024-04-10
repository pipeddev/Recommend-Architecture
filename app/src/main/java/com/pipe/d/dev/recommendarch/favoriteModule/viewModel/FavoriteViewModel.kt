package com.pipe.d.dev.recommendarch.favoriteModule.viewModel

import androidx.lifecycle.viewModelScope
import com.pipe.d.dev.recommendarch.R
import com.pipe.d.dev.recommendarch.common.entities.Wine
import com.pipe.d.dev.recommendarch.common.utils.Constants
import com.pipe.d.dev.recommendarch.common.viewModel.BaseWineViewModel
import com.pipe.d.dev.recommendarch.favoriteModule.model.FavoriteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoriteViewModel(private val repository: FavoriteRepository): BaseWineViewModel() {

    init {
        getAllWines()
    }

    override fun getAllWines() {
        viewModelScope.launch {
            setInProgress(Constants.SHOW)
            try {
                withContext(Dispatchers.IO) {
                    val result = repository.getAllWines()
                    result?.let { setWines(result) }
                    if (result == null){
                        setSnackbarMsg(R.string.room_request_fail)
                    }
                }
            } finally {
                setInProgress(Constants.HIDE)
            }
        }
    }

    override fun addWine(wine: Wine) {
        viewModelScope.launch {
            setInProgress(Constants.SHOW)
            try {
                withContext(Dispatchers.IO) {
                    val result = repository.addWine(wine)
                    if (result != -1L) {
                        setSnackbarMsg(R.string.room_save_success)
                    } else {
                        setSnackbarMsg(R.string.room_save_fail)
                    }
                }
            }finally {
                setInProgress(Constants.HIDE)
            }
        }
    }
    fun deleteWine(wine: Wine) {
        viewModelScope.launch {
            setInProgress(Constants.SHOW)
            try {
                withContext(Dispatchers.IO) {
                    val result = repository.deleteWine(wine)
                    if (result == 0) {
                        setSnackbarMsg(R.string.room_save_fail)
                    } else {
                        setSnackbarMsg(R.string.room_save_success)
                    }
                }
            }finally {
                setInProgress(Constants.HIDE)
            }
        }
    }
}