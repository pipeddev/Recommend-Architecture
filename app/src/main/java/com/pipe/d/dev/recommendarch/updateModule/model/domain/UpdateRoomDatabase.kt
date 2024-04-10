package com.pipe.d.dev.recommendarch.updateModule.model.domain

import com.pipe.d.dev.recommendarch.common.dataAccess.room.WineDao
import com.pipe.d.dev.recommendarch.common.entities.Wine

class UpdateRoomDatabase(private val dao: WineDao) {
    fun getWineById(id: Double) = dao.getWineById(id)
    fun updateWine(wine: Wine, newRating: String, callback: () -> Unit) {
        wine.rating.average = newRating
        val result = dao.updateWine(wine)
        if (result == 0) throw Exception() else callback()
    }
}