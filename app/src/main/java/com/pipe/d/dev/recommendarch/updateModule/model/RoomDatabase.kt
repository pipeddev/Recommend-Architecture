package com.pipe.d.dev.recommendarch.updateModule.model

import com.pipe.d.dev.recommendarch.WineApplication
import com.pipe.d.dev.recommendarch.common.dataAccess.room.WineDao
import com.pipe.d.dev.recommendarch.common.entities.Wine


class RoomDatabase {
    private val dao: WineDao by lazy { WineApplication.database.wineDao() }

    fun getWineById(id: Double) = dao.getWineById(id)
    fun updateWine(wine: Wine) = dao.updateWine(wine)
}