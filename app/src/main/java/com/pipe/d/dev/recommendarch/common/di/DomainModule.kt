package com.pipe.d.dev.recommendarch.common.di

import com.pipe.d.dev.recommendarch.homeModule.model.HomeRoomDatabase
import com.pipe.d.dev.recommendarch.homeModule.model.HomeWineService
import org.koin.dsl.module

val domainModule = module {
    factory { HomeRoomDatabase(get()) }
    factory { HomeWineService(get()) }
}