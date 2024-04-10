package com.pipe.d.dev.recommendarch.homeModule.model.domain

import com.pipe.d.dev.recommendarch.common.dataAccess.retrofit.WineService

class HomeWineService(private val service: WineService) {
    suspend fun getRedWines() = service.getRedWines()
}