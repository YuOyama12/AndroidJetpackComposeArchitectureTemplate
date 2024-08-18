package com.example.data.util

import retrofit2.Response
import timber.log.Timber
import java.io.IOException

class ApiDispatcher {
    companion object {
        suspend fun <T> execute(
            request: suspend () -> Response<T>,
            onSuccess: (T) -> T = { it },
            onFailure: (T?) -> T? = { null }
        ): T? {
            try {
                if (request().isSuccessful) {
                    val result = request().body()
                    result?.let {
                        return onSuccess(it)
                    } ?: return onFailure(null)
                } else {
                    Timber.tag("OkHttp").e(request().errorBody()?.string())
                    return onFailure(null)
                }
            } catch (e: IOException) {
                Timber.tag("OkHttp").e(e)
                return onFailure(null)
            }
        }
    }
}