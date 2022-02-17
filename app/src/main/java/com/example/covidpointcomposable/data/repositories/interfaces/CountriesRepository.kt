package com.example.covidpointcomposable.data.repositories.interfaces

import com.example.covidpointcomposable.data.database.countries.CountryEntity
import com.example.covidpointcomposable.data.pojo.CountriesResponse
import com.example.covidpointcomposable.data.pojo.CountryResponse
import com.example.covidpointcomposable.data.network.utils.Result

interface CountriesRepository {

    suspend fun getDataFromDB(): List<CountryEntity>

    suspend fun addDataToDB(countries: List<CountryEntity>)

    suspend fun addDataToDB(country: CountryEntity)

    suspend fun getDataFromNetwork(): Result<CountriesResponse>

    suspend fun getDataFromNetworkById(id: Int): Result<CountryResponse>
}