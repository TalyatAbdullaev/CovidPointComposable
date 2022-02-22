package com.example.covidpointcomposable.presentation.screens.list.di

import com.example.covidpointcomposable.data.repositories.interfaces.CountriesRepository
import com.example.covidpointcomposable.presentation.screens.list.ListViewModel
import dagger.Module
import dagger.Provides

@Module
class ListScreenModule {

    @Provides
    @ListScreenScope
    fun provideSplashViewModel(repository: CountriesRepository): ListViewModel = ListViewModel(repository)
}