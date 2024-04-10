package com.pipe.d.dev.recommendarch.favoriteModule.model

import com.pipe.d.dev.recommendarch.common.entities.Wine

class FavoriteRepository(private val db: RoomDatabase) {
    fun getAllWines(): List<Wine>? {
        return try {
            db.getAllWines()
        } catch (ex: Exception) {
            null
        }
    }
    fun addWine(wine: Wine): Long {
        return db.addWine(wine)
    }
    fun deleteWine(wine: Wine): Int {
        return db.deleteWine(wine)
    }
}