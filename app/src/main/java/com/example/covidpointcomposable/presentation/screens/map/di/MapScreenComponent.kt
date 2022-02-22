package com.example.covidpointcomposable.presentation.screens.map.di

import com.example.covidpointcomposable.presentation.screens.map.MapViewModel
import dagger.Component
import dagger.Subcomponent

@MapScreenScope
@Subcomponent(modules = [MapScreenModule::class])
interface MapScreenComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): MapScreenComponent
    }

    fun getViewModel() : MapViewModel
}