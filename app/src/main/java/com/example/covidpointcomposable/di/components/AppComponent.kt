package com.example.covidpointcomposable.di

import com.example.covidpointcomposable.MainActivity
import com.example.covidpointcomposable.di.modules.AppModule
import com.example.covidpointcomposable.di.modules.DatabaseModule
import com.example.covidpointcomposable.di.modules.NetworkModule
import com.example.covidpointcomposable.di.modules.RepositoriesModule
import com.example.covidpointcomposable.presentation.screens.list.di.ListScreenComponent
import com.example.covidpointcomposable.presentation.screens.map.di.MapScreenComponent
import com.example.covidpointcomposable.presentation.screens.splash.di.SplashScreenComponent
import dagger.Component

@Component(
    modules = [AppModule::class, DatabaseModule::class, NetworkModule::class, RepositoriesModule::class]

)
interface AppComponent {
    fun inject(activity: MainActivity)

    val splashScreenComponent: SplashScreenComponent.Builder
    val mapScreenComponent: MapScreenComponent.Builder
    val listScreenComponent : ListScreenComponent.Builder
}