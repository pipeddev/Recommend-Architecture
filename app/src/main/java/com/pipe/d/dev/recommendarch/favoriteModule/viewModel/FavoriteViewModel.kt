package com.pipe.d.dev.recommendarch.favoriteModule.viewModel

import com.pipe.d.dev.recommendarch.common.entities.Wine
import com.pipe.d.dev.recommendarch.common.viewModel.BaseWineViewModel
import com.pipe.d.dev.recommendarch.favoriteModule.model.FavoriteRepository

class FavoriteViewModel(private val repository: FavoriteRepository): BaseWineViewModel() {

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

    fun updateFavorite(wine: Wine) {
        executeAction {
            repository.updateFavorite(wine){resMsg ->
                setSnackbarMsg(resMsg)
            }
        }
    }
}