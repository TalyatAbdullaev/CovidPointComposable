package com.example.covidpointcomposable.presentation.screens.splash

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.*
import com.example.covidpointcomposable.data.database.countries.CountryEntity
import com.example.covidpointcomposable.data.mapper.CountryMapper
import com.example.covidpointcomposable.data.mapper.CountryMapperImpl
import com.example.covidpointcomposable.data.network.utils.Result
import com.example.covidpointcomposable.data.pojo.Country
import com.example.covidpointcomposable.data.repositories.interfaces.CountriesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val repository: CountriesRepository,
    private val mapper: CountryMapper<Country, CountryEntity>
) : ViewModel() {

    private val _dataIsReady = MutableStateFlow(false)
    val dataIsReady: StateFlow<Boolean> = _dataIsReady

    init {
        getCountriesFromNetwork()
    }

    private fun getCountriesFromNetwork() {
        viewModelScope.launch {
            val response = repository.getDataFromNetwork()
            Log.d("TAG", response.toString())

            when (response) {
                is Result.Success -> {
                    val countries: List<CountryEntity> = response.data.locations.mapNotNull {
                        if (it.coordinates.latitude.isNotEmpty() && it.coordinates.longitude.isNotEmpty()) {
                            mapper.mapToEntity(it)
                        } else
                            null
                    }
                    repository.addDataToDB(countries)
                }
                is Result.Error -> {
                    Log.d("TAG", "error - " + response.throwable.message)
                }
            }
            _dataIsReady.value = true
        }
    }
}