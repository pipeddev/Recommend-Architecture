package com.pipe.d.dev.recommendarch.homeModule.model

import com.pipe.d.dev.recommendarch.common.dataAccess.room.WineDao
import com.pipe.d.dev.recommendarch.common.entities.Wine

class HomeRoomDatabase(private val dao: WineDao) {
    //private val dao: WineDao by lazy { WineApplication.database.wineDao() }

    fun addWine(wine: Wine) = dao.addWine(wine)
}