package com.example.covidpointcomposable.data.repositories

import com.example.covidpointcomposable.data.database.countries.CountryEntity
import com.example.covidpointcomposable.data.datasource.interfaces.DatabaseSource
import com.example.covidpointcomposable.data.datasource.interfaces.NetworkSource
import com.example.covidpointcomposable.data.network.utils.Result
import com.example.covidpointcomposable.data.pojo.CountriesResponse
import com.example.covidpointcomposable.data.pojo.CountryResponse
import com.example.covidpointcomposable.data.repositories.interfaces.CountriesRepository
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(
    private val networkSource: NetworkSource,
    private val databaseSource: DatabaseSource
) : CountriesRepository {

    override suspend fun getDataFromDB(): List<CountryEntity> =
        databaseSource.getCountries()

    override suspend fun addDataToDB(countries: List<CountryEntity>) =
        databaseSource.insertCountries(countries)

    override suspend fun getDataFromNetwork(): Result<CountriesResponse> =
        networkSource.getCountries()

    override suspend fun getDataFromNetworkById(id: Int): Result<CountryResponse> =
        networkSource.getCountryStatistic(id)

    override suspend fun addDataToDB(country: CountryEntity) {
        databaseSource.insertCountry(country)
    }
}