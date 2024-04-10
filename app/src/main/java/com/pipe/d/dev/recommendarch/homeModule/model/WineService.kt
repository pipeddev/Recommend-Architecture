package com.pipe.d.dev.recommendarch.homeModule.model

import com.pipe.d.dev.recommendarch.common.dataAccess.retrofit.WineService
import com.pipe.d.dev.recommendarch.common.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WineService {
    suspend fun getRedWines() = getService().getRedWines()

    private fun getService(): WineService {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(WineService::class.java)
    }
}