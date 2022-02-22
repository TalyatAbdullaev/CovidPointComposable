package com.example.covidpointcomposable.presentation.screens.list.extensions

import com.example.covidpointcomposable.data.network.utils.Urls

fun String.urlByCountryCode(): String =
    String.format(Urls.COUNTRY_FLAG_URL, this.lowercase())