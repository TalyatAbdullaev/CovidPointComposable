package com.example.covidpointcomposable.data.database.countries

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.covidpointcomposable.data.database.countries.utils.CountriesDatabaseConstants

@Entity(tableName = CountriesDatabaseConstants.COUNTRIES_TABLE_NAME)
data class CountryEntity(

    @PrimaryKey
    val id: Int,

    val country: String,

    val countryCode: String,

    val countryPopulation: Int,

    val province: String,

    val latitude: Double,

    val longitude: Double,

    val confirmed: Int,

    val deaths: Int,

    val recovered: Int,

    val confirmedStats: Map<String, Int>?
)
