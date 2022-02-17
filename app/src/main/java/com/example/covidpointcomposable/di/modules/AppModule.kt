package com.example.covidpointcomposable.di.modules

import android.content.Context
import com.example.covidpointcomposable.di.App
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val app: App) {

    @Provides
    fun provideApplication(): App = app

    @Provides
    fun provideContext(): Context = app.applicationContext
}