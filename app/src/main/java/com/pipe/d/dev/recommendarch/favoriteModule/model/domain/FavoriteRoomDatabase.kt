package com.pipe.d.dev.recommendarch.favoriteModule.model.domain

import com.pipe.d.dev.recommendarch.R
import com.pipe.d.dev.recommendarch.common.dataAccess.room.WineDao
import com.pipe.d.dev.recommendarch.common.entities.Wine

class FavoriteRoomDatabase(private val dao: WineDao) {

    fun getAllWines() = dao.getAllWines()

    fun updateFavorite(wine: Wine, callback: (Int) -> Unit) {
        wine.isFavorite = !wine.isFavorite
        val result = if(wine.isFavorite) {
            addWine(wine)
        } else {
            deleteWine(wine)
        }
        callback(result)
    }

    private fun addWine(wine: Wine): Int {
        val result = dao.addWine(wine)
        return if(result != -1L) R.string.room_save_success else R.string.room_save_fail
    }

    private fun deleteWine(wine: Wine): Int {
        val result = dao.deleteWine(wine)
        return if (result == 0) R.string.room_save_fail else R.string.room_save_success
    }
}