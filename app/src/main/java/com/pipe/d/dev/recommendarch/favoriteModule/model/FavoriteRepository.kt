package com.pipe.d.dev.recommendarch.favoriteModule.model

import com.pipe.d.dev.recommendarch.R
import com.pipe.d.dev.recommendarch.common.entities.MyException
import com.pipe.d.dev.recommendarch.common.entities.Wine
import com.pipe.d.dev.recommendarch.common.model.BaseRepository
import com.pipe.d.dev.recommendarch.common.utils.Constants
import com.pipe.d.dev.recommendarch.favoriteModule.model.domain.FavoriteRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FavoriteRepository(private val db: FavoriteRoomDatabase): BaseRepository() {
    suspend fun getAllWines(callback: (List<Wine>) -> Unit) = withContext(Dispatchers.IO){
        executeAction(MyException(Constants.EC_REQUEST, R.string.home_no_wines)) {
            callback(db.getAllWines())
        }
    }

    suspend fun updateFavorite(wine: Wine, callback: (Int) -> Unit) = withContext(Dispatchers.IO) {
        executeAction(MyException(Constants.EC_UPDATE_WINE, R.string.room_update_fail)) {
            db.updateFavorite(wine) {result ->
                callback(result)
            }
        }
    }
}