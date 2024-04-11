package com.pipe.d.dev.recommendarch.promoModule.model

import com.pipe.d.dev.recommendarch.R
import com.pipe.d.dev.recommendarch.common.entities.MyException
import com.pipe.d.dev.recommendarch.common.entities.Promo
import com.pipe.d.dev.recommendarch.common.model.BaseRepository
import com.pipe.d.dev.recommendarch.common.utils.Constants
import com.pipe.d.dev.recommendarch.promoModule.model.domain.PromoDatabase

class PromoRepository(private val db: PromoDatabase): BaseRepository() {
    suspend fun getPromos(callback: (List<Promo>) -> Unit) {
        executeAction(MyException(Constants.EC_REQUEST, R.string.promo_request_fail)) {
            callback(db.getPromos())
        }
    }
}