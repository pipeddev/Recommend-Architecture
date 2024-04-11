package com.pipe.d.dev.recommendarch.promoModule.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pipe.d.dev.recommendarch.common.entities.MyException
import com.pipe.d.dev.recommendarch.common.entities.Promo
import com.pipe.d.dev.recommendarch.common.viewModel.BaseViewModel
import com.pipe.d.dev.recommendarch.promoModule.model.PromoRepository
import kotlinx.coroutines.launch

class PromoViewModel(private val repository: PromoRepository): BaseViewModel() {
    private val _promos = MutableLiveData<List<Promo>>()
    val promos: LiveData<List<Promo>> = _promos

    init {
        getPromos()
    }

    private fun getPromos() {
        executeAction {
            repository.getPromos { promos ->
                _promos.value = promos
            }
        }
    }

    override fun onPause() = clearValues()
}