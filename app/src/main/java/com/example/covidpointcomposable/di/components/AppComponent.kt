package com.example.covidpointcomposable.di

import com.example.covidpointcomposable.MainActivity
import com.example.covidpointcomposable.di.modules.AppModule
import com.example.covidpointcomposable.di.modules.DatabaseModule
import com.example.covidpointcomposable.di.modules.NetworkModule
import com.example.covidpointcomposable.di.modules.RepositoriesModule
import dagger.Component

@Component(
    modules = [AppModule::class, DatabaseModule::class, NetworkModule::class, RepositoriesModule::class]
)
interface AppComponent {
    fun inject(activity: MainActivity)
}