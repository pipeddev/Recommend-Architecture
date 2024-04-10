package com.pipe.d.dev.recommendarch.common.di

import com.pipe.d.dev.recommendarch.favoriteModule.viewModel.FavoriteViewModel
import com.pipe.d.dev.recommendarch.homeModule.viewModel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
}