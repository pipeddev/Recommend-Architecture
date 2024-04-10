package com.pipe.d.dev.recommendarch.promoModule.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pipe.d.dev.recommendarch.common.entities.MyException
import com.pipe.d.dev.recommendarch.common.entities.Promo
import com.pipe.d.dev.recommendarch.promoModule.model.PromoRepository
import kotlinx.coroutines.launch

class PromoViewModel(private val repository: PromoRepository): ViewModel() {
    private val _snackBarMsg = MutableLiveData<Int>()
    val snackBarMsg: LiveData<Int> = _snackBarMsg

    private val _promos = MutableLiveData<List<Promo>>()
    val promos: LiveData<List<Promo>> = _promos

    init {
        getPromos()
    }

    private fun getPromos() {
        viewModelScope.launch {

            try {
                _promos.value = repository.getPromos()
            } catch (ex: MyException) {
                _snackBarMsg.value = ex.resMsg
            }
        }
    }
}