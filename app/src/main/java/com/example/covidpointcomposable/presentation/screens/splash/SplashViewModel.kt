package com.example.covidpointcomposable.presentation.screens.splash

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.covidpointcomposable.data.database.countries.CountryEntity
import com.example.covidpointcomposable.data.mapper.CountryMapperImpl
import com.example.covidpointcomposable.data.network.utils.Result
import com.example.covidpointcomposable.data.repositories.interfaces.CountriesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SplashViewModel(
    private val repository: CountriesRepository,
    private val mapper: CountryMapperImpl
) : ViewModel() {

    private val _dataIsReady = MutableLiveData<Boolean>(false)
    val dataIsReady: LiveData<Boolean> = _dataIsReady

    val state = MutableStateFlow(false)

    init {
        getCountriesFromNetwork()
    }

    private fun getCountriesFromNetwork() {
        viewModelScope.launch {
            val response = repository.getDataFromNetwork()

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