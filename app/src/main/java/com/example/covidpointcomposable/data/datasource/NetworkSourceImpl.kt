package com.example.covidpointcomposable.data.datasource

import com.example.covidpointcomposable.data.datasource.interfaces.NetworkSource
import com.example.covidpointcomposable.data.network.services.CountryApiService
import com.example.covidpointcomposable.data.pojo.CountriesResponse
import com.example.covidpointcomposable.data.pojo.CountryResponse
import javax.inject.Inject

class NetworkSourceImpl @Inject constructor(private val countryApiService: CountryApiService) :
    NetworkSource {

    private suspend fun <T> requestHandler(request: suspend () -> T): Result<T> {
        return try {
            val result = request()
            Result.success(result)
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }

    override suspend fun getCountries(): Result<CountriesResponse> =
        requestHandler { countryApiService.getCountries() }

    override suspend fun getCountryStatistic(id: Int): Result<CountryResponse> =
        requestHandler { countryApiService.getCountryStatistics(id) }
}