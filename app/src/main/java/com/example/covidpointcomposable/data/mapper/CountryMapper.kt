package com.example.covidpointcomposable.data.mapper

interface CountryMapper<E, D> {

    fun mapToEntity(type: E): D

    //    fun mapFromEntity(type: D): E
}