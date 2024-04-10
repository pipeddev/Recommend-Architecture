package com.pipe.d.dev.recommendarch.homeModule.model

import com.pipe.d.dev.recommendarch.R
import com.pipe.d.dev.recommendarch.common.entities.MyException
import com.pipe.d.dev.recommendarch.common.entities.Wine
import com.pipe.d.dev.recommendarch.common.model.BaseRepository
import com.pipe.d.dev.recommendarch.common.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.random.Random

class HomeRepository(
    private val db: RoomDatabase,
    private val service: WineService): BaseRepository() {

    suspend fun getAllWines(callback: (List<Wine>) -> Unit) = withContext(Dispatchers.IO) {
        executeAction(MyException(Constants.EC_REQUEST, R.string.common_general_fail)) {
            val serverOk = if(Random.nextBoolean()) true else Random.nextBoolean()
            val wines = if (serverOk) service.getRedWines() else listOf()
            callback(wines)
        }
    }
    suspend fun addWine(wine: Wine, callback: () -> Unit) = withContext(Dispatchers.IO) {
        executeAction {
            val result = db.addWine(wine)
            if (result == -1L) {
                throw MyException(Constants.EC_SAVE_WINE, R.string.room_save_fail)
            } else {
                callback()
            }
        }

    }
}