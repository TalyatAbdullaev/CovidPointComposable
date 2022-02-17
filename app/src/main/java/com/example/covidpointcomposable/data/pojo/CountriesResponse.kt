package com.example.covidpointcomposable.data.pojo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountriesResponse(
    @SerialName("locations")
    val locations: List<Country>
)
