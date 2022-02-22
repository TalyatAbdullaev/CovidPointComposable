package com.example.covidpointcomposable.presentation.screens.splash.di

import com.example.covidpointcomposable.data.database.countries.CountryEntity
import com.example.covidpointcomposable.data.mapper.CountryMapper
import com.example.covidpointcomposable.data.mapper.CountryMapperImpl
import com.example.covidpointcomposable.data.pojo.Country
import com.example.covidpointcomposable.data.repositories.interfaces.CountriesRepository
import com.example.covidpointcomposable.presentation.screens.splash.SplashViewModel
import dagger.Module
import dagger.Provides

@Module
class SplashScreenModule {

    @Provides
    fun provideSplashViewModel(
        repository: CountriesRepository,
        mapper: CountryMapper<Country, CountryEntity>
    ): SplashViewModel = SplashViewModel(repository, mapper)
}