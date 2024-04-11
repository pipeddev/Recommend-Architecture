package com.pipe.d.dev.recommendarch.updateModule.model.domain

import com.pipe.d.dev.recommendarch.R
import com.pipe.d.dev.recommendarch.common.dataAccess.room.WineDao
import com.pipe.d.dev.recommendarch.common.entities.Wine

class UpdateRoomDatabase(private val dao: WineDao) {
    fun getWineById(id: Double) = dao.getWineById(id)

    fun updateWine(wine: Wine?, newRating: String, callback: (Int) -> Unit) {
        wine?.let {
            wine.rating.average = newRating
            val result = dao.updateWine(wine)
            if (result == 0) throw Exception() else callback(R.string.room_save_success)
        }

    }
}