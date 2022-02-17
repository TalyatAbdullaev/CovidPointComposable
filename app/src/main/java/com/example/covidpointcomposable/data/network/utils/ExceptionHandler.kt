package com.example.covidpointcomposable.data.network.utilss

import android.content.Context
import com.example.covidpointcomposable.R
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ExceptionHandler(private val context: Context) {

    fun requestHandler(throwable: Throwable): String {
        return when(throwable) {
            is UnknownHostException-> context.getString(R.string.message_error_connect)
            is HttpException -> context.getString(R.string.message_error_server)
            is SocketTimeoutException -> context.getString(R.string.message_error_server)
            else -> context.getString(R.string.message_error_default_title)
        }
    }
}