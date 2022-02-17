package com.example.covidpointcomposable.data.pojo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Confirmed(
    @SerialName("timeline")
    val timeline: Map<String, Int>?
)
