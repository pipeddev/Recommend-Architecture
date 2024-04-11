package com.pipe.d.dev.recommendarch.common.di

import com.pipe.d.dev.recommendarch.common.viewModel.ShareFragmentViewModel
import com.pipe.d.dev.recommendarch.common.viewModel.ShareViewModel
import com.pipe.d.dev.recommendarch.favoriteModule.viewModel.FavoriteViewModel
import com.pipe.d.dev.recommendarch.homeModule.viewModel.HomeViewModel
import com.pipe.d.dev.recommendarch.loginModule.viewModel.LoginViewModel
import com.pipe.d.dev.recommendarch.updateModule.viewModel.UpdateViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { UpdateViewModel(get()) }
    viewModel { ShareFragmentViewModel() }
    viewModel { LoginViewModel(get())}
    viewModel { ShareViewModel() }
}