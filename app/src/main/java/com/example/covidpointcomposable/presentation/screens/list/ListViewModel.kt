package com.example.covidpointcomposable.presentation.screens.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iwgroup.covidpoint.data.database.countries.CountryEntity

class ListViewModel: ViewModel() {

    private val _countries = MutableLiveData<List<CountryEntity>>()
    val countries: LiveData<List<CountryEntity>> = _countries
}