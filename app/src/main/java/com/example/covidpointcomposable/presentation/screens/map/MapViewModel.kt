package com.example.covidpointcomposable.presentation.screens.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.covidpointcomposable.data.database.countries.CountryEntity
import com.example.covidpointcomposable.data.repositories.interfaces.CountriesRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MapViewModel @Inject constructor(private val repository: CountriesRepository): ViewModel() {
    private val _countries = MutableLiveData<List<CountryEntity>>()
    val countries: LiveData<List<CountryEntity>> = _countries

    init {
        getCountriesFromDB()
    }

    private fun getCountriesFromDB() {
        viewModelScope.launch {
            _countries.value = repository.getDataFromDB()
        }
    }
}