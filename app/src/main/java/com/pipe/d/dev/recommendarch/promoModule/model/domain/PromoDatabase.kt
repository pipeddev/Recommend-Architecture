package com.pipe.d.dev.recommendarch.promoModule.model.domain

import com.pipe.d.dev.recommendarch.common.dataAccess.local.getAllPromos
import com.pipe.d.dev.recommendarch.common.entities.Promo


class PromoDatabase {
    fun getPromos(): List<Promo> {
        val result = getAllPromos()
        return result.ifEmpty {
            throw Exception()
        }

    }
}