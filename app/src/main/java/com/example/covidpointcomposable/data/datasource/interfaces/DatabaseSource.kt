package com.example.covidpointcomposable.data.datasource.interfaces

import com.example.covidpointcomposable.data.database.countries.CountryEntity

interface DatabaseSource {

    suspend fun insertCountries(countries: List<CountryEntity>)

    suspend fun insertCountry(country: CountryEntity)

    suspend fun getCountries(): List<CountryEntity>
}