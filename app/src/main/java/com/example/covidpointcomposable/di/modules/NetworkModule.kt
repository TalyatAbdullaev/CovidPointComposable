package com.example.covidpointcomposable.di.modules

import android.content.Context
import com.example.covidpointcomposable.data.network.services.CountryApiService
import com.example.covidpointcomposable.data.network.utils.Urls
import com.example.covidpointcomposable.data.network.utilss.ExceptionHandler
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
class NetworkModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder().build()

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val contentType = MediaType.get("application/json")

        return Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory(contentType))
            .baseUrl(Urls.BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideApiService (retrofit: Retrofit): CountryApiService =
        retrofit.create(CountryApiService::class.java)

    @Provides
    fun provideExceptionHandler(context: Context): ExceptionHandler =
        ExceptionHandler(context)
}