package com.example.covidpointcomposable.di

import android.app.Application
import com.example.covidpointcomposable.data.network.utils.ApiKeys
import com.example.covidpointcomposable.di.modules.AppModule
import com.yandex.mapkit.MapKitFactory

class App : Application() {
    companion object {
        lateinit var graph: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        MapKitFactory.setApiKey(ApiKeys.YANDEX_API_KEY)

        graph = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}