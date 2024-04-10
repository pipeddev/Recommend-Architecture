package com.pipe.d.dev.recommendarch.homeModule.model.domain

import com.pipe.d.dev.recommendarch.common.dataAccess.room.WineDao
import com.pipe.d.dev.recommendarch.common.entities.Wine

class HomeRoomDatabase(private val dao: WineDao) {
    fun addWine(wine: Wine) = dao.addWine(wine)
}