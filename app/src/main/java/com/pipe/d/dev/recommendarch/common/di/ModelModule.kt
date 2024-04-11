package com.pipe.d.dev.recommendarch.common.di

import com.pipe.d.dev.recommendarch.favoriteModule.model.FavoriteRepository
import com.pipe.d.dev.recommendarch.homeModule.model.HomeRepository
import com.pipe.d.dev.recommendarch.loginModule.model.LoginRepository
import com.pipe.d.dev.recommendarch.updateModule.model.UpdateRepository
import org.koin.dsl.module

val modelModule = module {
    factory { HomeRepository(get(), get()) }
    factory { FavoriteRepository(get()) }
    factory { UpdateRepository(get()) }
    factory { LoginRepository(get()) }
}