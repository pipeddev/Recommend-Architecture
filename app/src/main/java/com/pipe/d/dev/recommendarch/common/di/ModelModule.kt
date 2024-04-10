package com.pipe.d.dev.recommendarch.common.di

import com.pipe.d.dev.recommendarch.homeModule.model.HomeRepository
import org.koin.dsl.module

val modelModule = module {
    factory { HomeRepository(get(), get()) }
}