package com.pipe.d.dev.recommendarch.common.di

import com.pipe.d.dev.recommendarch.favoriteModule.model.domain.FavoriteRoomDatabase
import com.pipe.d.dev.recommendarch.homeModule.model.domain.HomeRoomDatabase
import com.pipe.d.dev.recommendarch.homeModule.model.domain.HomeWineService
import org.koin.dsl.module

val domainModule = module {
    factory { HomeRoomDatabase(get()) }
    factory { HomeWineService(get()) }
    factory { FavoriteRoomDatabase(get()) }
}