package com.cc.fairy.app

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import com.cc.fairy.database.FairyDatabase

/**
 *@author:  MidChen
 *@email:   chen.b@tuta.io
 *@time:    2023/5/21 17:02
 */

class App : Application(), ImageLoaderFactory {

    companion object {
        lateinit var app: App
        val db: FairyDatabase by lazy {
            FairyDatabase.instance(app)
        }
    }

    override fun onCreate() {
        super.onCreate()
        app = this
    }

    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .crossfade(true)
            .build()
    }

}