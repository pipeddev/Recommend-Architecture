package com.pipe.d.dev.recommendarch.homeModule.viewModel

import androidx.lifecycle.viewModelScope
import com.pipe.d.dev.recommendarch.R
import com.pipe.d.dev.recommendarch.common.entities.MyException
import com.pipe.d.dev.recommendarch.common.entities.Wine
import com.pipe.d.dev.recommendarch.common.utils.Constants
import com.pipe.d.dev.recommendarch.common.viewModel.BaseWineViewModel
import com.pipe.d.dev.recommendarch.homeModule.model.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val repository: HomeRepository): BaseWineViewModel() {

    init {
        getAllWines()
    }

    fun onPause() {
        clearValues()
    }

    private fun clearValues() {
        setSnackbarMsg(null)
    }

    override fun getAllWines() {
        viewModelScope.launch {
            setInProgress(Constants.SHOW)
            try {
                withContext(Dispatchers.IO) {
                    repository.getAllWines { wines ->
                        setWines(wines)
                    }
                }
            }catch (ex: MyException) {
                setSnackbarMsg(ex.resMsg)
            }finally {
                setInProgress(Constants.HIDE)
            }
        }
    }

    override fun addWine(wine: Wine) {
        viewModelScope.launch {
            setInProgress(Constants.SHOW)
            try {
                withContext(Dispatchers.IO) {
                    repository.addWine(wine) {
                        setSnackbarMsg(R.string.room_save_success)
                    }
                }
            }catch (ex: MyException) {
                setSnackbarMsg(ex.resMsg)
            }finally {
                setInProgress(Constants.HIDE)
            }
        }
    }
}