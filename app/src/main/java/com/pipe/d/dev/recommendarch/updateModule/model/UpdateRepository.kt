package com.pipe.d.dev.recommendarch.updateModule.model

import com.pipe.d.dev.recommendarch.R
import com.pipe.d.dev.recommendarch.common.entities.MyException
import com.pipe.d.dev.recommendarch.common.entities.Wine
import com.pipe.d.dev.recommendarch.common.model.BaseRepository
import com.pipe.d.dev.recommendarch.common.utils.Constants
import com.pipe.d.dev.recommendarch.updateModule.model.domain.UpdateRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UpdateRepository(private val db: UpdateRoomDatabase): BaseRepository() {
    suspend fun requestWine(id: Double, callback: (Wine) -> Unit) = withContext(Dispatchers.IO) {
        executeAction(MyException(Constants.EC_GET_WINE, R.string.room_request_fail)) {
            callback(db.getWineById(id))
        }
    }

    suspend fun updateWine(wine: Wine?, newRating: String, callback: () -> Unit) = withContext(Dispatchers.IO) {
        executeAction(MyException(Constants.EC_UPDATE_WINE, R.string.room_update_fail)) {
            db.updateWine(wine, newRating) { callback() }
        }
    }
}