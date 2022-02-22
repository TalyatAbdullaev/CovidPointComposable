package com.example.covidpointcomposable.data.mapper

import com.example.covidpointcomposable.data.database.countries.CountryEntity
import com.example.covidpointcomposable.data.pojo.Country

class CountryMapperImpl : CountryMapper<Country, CountryEntity> {

    override fun mapToEntity(type: Country): CountryEntity {
        var stats: Map<String, Int>? = null
        if (type.timelines != null) {
            stats = type.timelines.confirmed?.timeline
        }

        return CountryEntity(
            type.id,
            type.country,
            type.countryCode,
            type.countryPopulation?: 0,
            type.province,
            type.coordinates.latitude.toDouble(),
            type.coordinates.longitude.toDouble(),
            type.latest.confirmed,
            type.latest.deaths,
            type.latest.recovered,
            stats
        )
    }
}