package com.pipe.d.dev.recommendarch.promoModule.di

import com.pipe.d.dev.recommendarch.promoModule.model.PromoRepository
import com.pipe.d.dev.recommendarch.promoModule.model.domain.PromoDatabase
import com.pipe.d.dev.recommendarch.promoModule.view.PromoListAdapter
import com.pipe.d.dev.recommendarch.promoModule.view.adapters.PromoDiff
import com.pipe.d.dev.recommendarch.promoModule.viewModel.PromoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val promoModule = module {
    single { PromoDatabase() }
    factory { PromoRepository(get()) }
    factory { PromoDiff() }
    factory { PromoListAdapter(get()) }
    viewModel { PromoViewModel(get()) }
}