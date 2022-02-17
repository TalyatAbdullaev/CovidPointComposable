package com.iwgroup.covidpoint.data.pojo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountryResponse(

    @SerialName("location")
    val location: Country
)