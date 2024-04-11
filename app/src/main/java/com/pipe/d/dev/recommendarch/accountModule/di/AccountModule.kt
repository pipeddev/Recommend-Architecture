package com.pipe.d.dev.recommendarch.accountModule.di

import com.pipe.d.dev.recommendarch.accountModule.model.AccountRepository
import com.pipe.d.dev.recommendarch.accountModule.model.domain.AccountAuth
import com.pipe.d.dev.recommendarch.accountModule.viewModel.AccountViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val accountModule = module {
    single { AccountAuth(get()) }
    factory { AccountRepository(get()) }
    viewModel { AccountViewModel(get()) }
}