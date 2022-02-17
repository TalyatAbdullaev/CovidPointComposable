package com.example.covidpointcomposable.presentation.screens.utils.extensions

import java.text.SimpleDateFormat
import java.util.*

fun String.convertDate(): String {

    val localDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(this)
    val outDateFormat = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())

    return if(localDate == null) { "" }
    else { outDateFormat.format(localDate) }
}