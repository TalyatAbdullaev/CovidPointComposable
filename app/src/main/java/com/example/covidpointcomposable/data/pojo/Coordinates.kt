package com.example.covidpointcomposable.data.pojo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Coordinates(
    @SerialName("latitude")
    val latitude: String,

    @SerialName("longitude")
    val longitude: String
)
