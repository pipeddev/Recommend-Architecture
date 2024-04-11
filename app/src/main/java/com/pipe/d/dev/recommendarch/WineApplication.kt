package com.pipe.d.dev.recommendarch

import android.app.Application
import androidx.room.Room
import com.pipe.d.dev.recommendarch.common.dataAccess.room.WineDatabase
import com.pipe.d.dev.recommendarch.common.di.adapterModule
import com.pipe.d.dev.recommendarch.common.di.dataSourceModule
import com.pipe.d.dev.recommendarch.common.di.domainModule
import com.pipe.d.dev.recommendarch.common.di.modelModule
import com.pipe.d.dev.recommendarch.common.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/****
 * Project: Wines
 * From: com.cursosant.wines
 * Created by Alain Nicolás Tello on 06/02/24 at 20:23
 * All rights reserved 2024.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * And Frogames formación:
 * https://cursos.frogamesformacion.com/pages/instructor-alain-nicolas
 *
 * Coupons on my Website:
 * www.alainnicolastello.com
 ***/
class WineApplication : Application() {
    /*companion object {
        lateinit var database: WineDatabase
    }*/

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WineApplication)
            modules(adapterModule, viewModelModule, modelModule, domainModule, dataSourceModule)
        }

        /*database = Room.databaseBuilder(this,
            WineDatabase::class.java,
            "WineDatabase")
            .build()
         */
    }
}