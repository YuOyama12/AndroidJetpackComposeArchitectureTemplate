package com.example.network.retrofit

import com.example.network.BuildConfig
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitNetwork @Inject constructor(
    private val networkJson: Json,
    private val okhttpCallFactory: OkHttpClient,
) {
    private val retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .callFactory { okhttpCallFactory.newBuilder().build().newCall(it) }
            .addConverterFactory (
                networkJson.asConverterFactory("application/json".toMediaType())
            ).build()

    val apiService: IApiService = retrofit.create(IApiService::class.java)
}