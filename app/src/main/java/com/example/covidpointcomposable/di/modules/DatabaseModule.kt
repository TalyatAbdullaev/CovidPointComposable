package com.example.covidpointcomposable.di.modules

import androidx.room.Room
import com.example.covidpointcomposable.data.database.countries.CountriesDao
import com.example.covidpointcomposable.data.database.countries.CountriesDatabase
import com.example.covidpointcomposable.data.database.countries.CountryEntity
import com.example.covidpointcomposable.data.database.countries.utils.CountriesDatabaseConstants
import com.example.covidpointcomposable.data.mapper.CountryMapper
import com.example.covidpointcomposable.data.mapper.CountryMapperImpl
import com.example.covidpointcomposable.data.pojo.Country
import com.example.covidpointcomposable.di.App
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun provideCountriesDatabase(app: App): CountriesDatabase =
        Room.databaseBuilder(
            app,
            CountriesDatabase::class.java,
            CountriesDatabaseConstants.COUNTRIES_DATABASE_NAME
        ).build()

    @Provides
    fun provideCountriesDao(db: CountriesDatabase): CountriesDao = db.countriesDao()

    @Provides
    fun provideMapper(): CountryMapper<Country, CountryEntity> = CountryMapperImpl()
}