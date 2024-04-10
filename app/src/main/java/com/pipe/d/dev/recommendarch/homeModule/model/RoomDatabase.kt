package com.pipe.d.dev.recommendarch.homeModule.model

import com.pipe.d.dev.recommendarch.WineApplication
import com.pipe.d.dev.recommendarch.common.dataAccess.room.WineDao
import com.pipe.d.dev.recommendarch.common.entities.Wine

class RoomDatabase {
    private val dao: WineDao by lazy { WineApplication.database.wineDao() }

    fun addWine(wine: Wine) = dao.addWine(wine)
}