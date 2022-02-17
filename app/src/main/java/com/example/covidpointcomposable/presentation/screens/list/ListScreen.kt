package com.example.covidpointcomposable.presentation.screens.list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.covidpointcomposable.presentation.screens.utils.CountryItem
import com.iwgroup.covidpoint.data.database.countries.CountryEntity

@Composable
fun ListScreen(viewModel: ListViewModel) {

    val countries: List<CountryEntity> by viewModel.countries.observeAsState(listOf())

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(countries) { country ->
            Card {
                val sum = country.confirmed + country.deaths + country.recovered

                CountryItem(
                    countryName = country.country,
                    imageURL = country.countryCode.urlByCountryCode(),
                    confirmedNum = country.confirmed,
                    confirmedProgress = calculateProgress(country.confirmed, sum),
                    deathsNum = country.deaths,
                    deathsProgress = calculateProgress(country.deaths, sum),
                    recoveredNum = country.recovered,
                    recoveredProgress = calculateProgress(country.recovered, sum),
                    startDate = "2020-01-22T00:00:00Z",
                    endDate = "2020-01-22T00:00:00Z"
                )
            }
        }
    }
}