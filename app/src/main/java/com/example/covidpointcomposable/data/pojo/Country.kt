package com.iwgroup.covidpoint.data.pojo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    @SerialName("id")
    val id: Int,

    @SerialName("country")
    val country: String,

    @SerialName("country_code")
    val countryCode: String,

    @SerialName("country_population")
    val countryPopulation: Int,

    @SerialName("province")
    val province: String,

    @SerialName("coordinates")
    val coordinates: Coordinates,

    @SerialName("latest")
    val latest: Statistic,

    @SerialName("timelines")
    val timelines: Timelines?
)