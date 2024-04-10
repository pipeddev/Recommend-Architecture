package com.pipe.d.dev.recommendarch.promoModule.model

import com.pipe.d.dev.recommendarch.common.dataAccess.local.getAllPromos


class Database {
    fun getPromos() = getAllPromos()
}