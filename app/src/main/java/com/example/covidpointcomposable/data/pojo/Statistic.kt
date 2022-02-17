package com.iwgroup.covidpoint.data.pojo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Statistic(

    @SerialName("confirmed")
    val confirmed: Int,

    @SerialName("deaths")
    val deaths: Int,

    @SerialName("recovered")
    val recovered: Int
)
