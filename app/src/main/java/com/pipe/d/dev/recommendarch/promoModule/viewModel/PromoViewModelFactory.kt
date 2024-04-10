package com.pipe.d.dev.recommendarch.promoModule.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pipe.d.dev.recommendarch.promoModule.model.PromoRepository

class PromoViewModelFactory(private val repository: PromoRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom((PromoViewModel::class.java))) {
            @Suppress("UNCHECKED_CAST")
            return PromoViewModel(repository) as T
        }
        throw IllegalArgumentException("Clase de ViewModel desconocida")
    }
}