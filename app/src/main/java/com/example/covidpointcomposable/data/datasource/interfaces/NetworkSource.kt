package com.example.covidpointcomposable.data.datasource.interfaces

import com.example.covidpointcomposable.data.network.utils.Result
import com.example.covidpointcomposable.data.pojo.CountriesResponse
import com.example.covidpointcomposable.data.pojo.CountryResponse


interface NetworkSource {

    suspend fun getCountries(): Result<CountriesResponse>

    suspend fun getCountryStatistic(id: Int): Result<CountryResponse>
}