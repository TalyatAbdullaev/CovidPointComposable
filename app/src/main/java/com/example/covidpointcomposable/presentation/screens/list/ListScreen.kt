package com.example.covidpointcomposable.presentation.screens.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.covidpointcomposable.data.database.countries.CountryEntity
import com.example.covidpointcomposable.presentation.screens.list.extensions.urlByCountryCode
import com.example.covidpointcomposable.presentation.screens.utils.CountryItem

@Composable
fun ListScreen(viewModel: ListViewModel) {

    val countries: List<CountryEntity> by viewModel.countries.observeAsState(listOf())

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(countries) { country ->
            Card(
                shape = RoundedCornerShape(20.dp),
                elevation = 4.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
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

private fun calculateProgress(value: Int, sum: Int): Float =
    value.toFloat() / sum.toFloat() * 100