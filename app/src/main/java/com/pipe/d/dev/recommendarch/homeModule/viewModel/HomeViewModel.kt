package com.pipe.d.dev.recommendarch.homeModule.viewModel

import com.pipe.d.dev.recommendarch.R
import com.pipe.d.dev.recommendarch.common.entities.Wine
import com.pipe.d.dev.recommendarch.common.viewModel.BaseWineViewModel
import com.pipe.d.dev.recommendarch.homeModule.model.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeViewModel(private val repository: HomeRepository): BaseWineViewModel() {
    init {
        getAllWines()
    }

    override fun onPause() = clearValues()

    override fun getAllWines() {
        executeAction {
            repository.getAllWines { wines ->
                setWines(wines)
            }
        }
    }

    override fun addWine(wine: Wine) {
        executeAction {
            repository.addWine(wine) {
                setSnackbarMsg(R.string.room_save_success)
            }
        }
    }
}