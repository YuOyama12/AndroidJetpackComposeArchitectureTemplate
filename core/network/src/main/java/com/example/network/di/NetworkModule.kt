package com.example.network.di

import android.util.Log
import androidx.core.os.trace
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun okHttpCallFactory(): OkHttpClient {
        val logging = HttpLoggingInterceptor {
            Log.d("OkHttp", it)
        }

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }



}