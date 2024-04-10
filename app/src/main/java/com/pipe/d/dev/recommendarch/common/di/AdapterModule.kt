package com.pipe.d.dev.recommendarch.common.di

import com.pipe.d.dev.recommendarch.common.utils.OnClickListener
import com.pipe.d.dev.recommendarch.favoriteModule.view.WineFavListAdapter
import com.pipe.d.dev.recommendarch.homeModule.view.WineDiff
import com.pipe.d.dev.recommendarch.homeModule.view.WineListAdapter
import org.koin.dsl.module

val adapterModule = module {
    factory { WineDiff()}
    factory<WineListAdapter> { (listener: OnClickListener) -> WineListAdapter(listener, get())  }
    factory<WineFavListAdapter> { (listener: OnClickListener) -> WineFavListAdapter(listener, get())  }
}