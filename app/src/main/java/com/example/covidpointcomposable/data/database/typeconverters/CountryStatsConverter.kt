package com.example.covidpointcomposable.data.database.typeconverters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@ProvidedTypeConverter
object CountryStatsConverter {
    @TypeConverter
    fun fromStringToMap(value: String?): Map<String, Int>? {
        return if(value.isNullOrEmpty())
            null
        else {
            Json.decodeFromString<Map<String, Int>>(value)
        }
    }

    @TypeConverter
    fun fromMapToString(map: Map<String, Int>?): String? {
        return if(map.isNullOrEmpty())
            null
        else
            Json.encodeToString(map)
    }
}