package com.example.covidpointcomposable.presentation.screens.map.di

import com.example.covidpointcomposable.data.repositories.interfaces.CountriesRepository
import com.example.covidpointcomposable.presentation.screens.map.MapViewModel
import dagger.Module
import dagger.Provides

@Module
class MapScreenModule {

    @Provides
    fun provideMapViewModel(repository: CountriesRepository): MapViewModel = MapViewModel(repository)
}