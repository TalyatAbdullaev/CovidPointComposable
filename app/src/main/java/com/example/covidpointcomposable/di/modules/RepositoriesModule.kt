package com.example.covidpointcomposable.di.modules

import com.example.covidpointcomposable.data.database.countries.CountriesDao
import com.example.covidpointcomposable.data.datasource.DatabaseSourceImpl
import com.example.covidpointcomposable.data.datasource.NetworkSourceImpl
import com.example.covidpointcomposable.data.datasource.interfaces.DatabaseSource
import com.example.covidpointcomposable.data.datasource.interfaces.NetworkSource
import com.example.covidpointcomposable.data.network.services.CountryApiService
import com.example.covidpointcomposable.data.repositories.CountriesRepositoryImpl
import com.example.covidpointcomposable.data.repositories.interfaces.CountriesRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoriesModule {

    @Provides
    fun provideDatabaseSource(dao: CountriesDao): DatabaseSource =
        DatabaseSourceImpl(dao)

    @Provides
    fun provideNetworkSource(countryApiService: CountryApiService): NetworkSource =
        NetworkSourceImpl(countryApiService)

    @Provides
    fun provideMainRepository(
        networkSource: NetworkSource,
        databaseSource: DatabaseSource
    ): CountriesRepository =
        CountriesRepositoryImpl(networkSource, databaseSource)
}