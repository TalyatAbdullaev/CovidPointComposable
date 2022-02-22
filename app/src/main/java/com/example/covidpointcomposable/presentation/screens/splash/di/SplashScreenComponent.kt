package com.example.covidpointcomposable.presentation.screens.splash.di

import com.example.covidpointcomposable.presentation.screens.splash.SplashViewModel
import dagger.Component
import dagger.Subcomponent

@Subcomponent(
    modules = [SplashScreenModule::class]
)
@SplashScreenScope
interface SplashScreenComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): SplashScreenComponent
    }

    fun getViewModel() : SplashViewModel
}