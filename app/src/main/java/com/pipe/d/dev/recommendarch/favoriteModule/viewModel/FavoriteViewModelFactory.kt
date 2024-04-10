package com.pipe.d.dev.recommendarch.favoriteModule.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pipe.d.dev.recommendarch.favoriteModule.model.FavoriteRepository


class FavoriteViewModelFactory(private val repository: FavoriteRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom((FavoriteViewModel::class.java))) {
            @Suppress("UNCHECKED_CAST")
            return FavoriteViewModel(repository) as T
        }
        throw IllegalArgumentException("Clase de ViewModel desconocida")
    }
}