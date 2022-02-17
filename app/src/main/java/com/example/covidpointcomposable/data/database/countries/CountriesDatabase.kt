package com.example.covidpointcomposable.data.database.countries

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.covidpointcomposable.data.database.typeconverters.CountryStatsConverter

@Database(entities = [CountryEntity::class], version = 1, exportSchema = false)
@TypeConverters(CountryStatsConverter::class)
abstract class CountriesDatabase : RoomDatabase() {

    abstract fun countriesDao(): CountriesDao
}