package com.example.covidpointcomposable.data.database.countries

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.covidpointcomposable.data.database.countries.utils.CountriesDatabaseConstants

@Dao
interface CountriesDao {
    @Query("SELECT * FROM ${CountriesDatabaseConstants.COUNTRIES_TABLE_NAME}")
    suspend fun getAllCountries(): List<CountryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountries(countries: List<CountryEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountry(country: CountryEntity)

    @Query("DELETE FROM ${CountriesDatabaseConstants.COUNTRIES_TABLE_NAME}")
    suspend fun deleteAllCountries()
}