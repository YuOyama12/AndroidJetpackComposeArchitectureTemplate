package com.example.data.di

import com.example.data.repository.ExampleRepository
import com.example.data.repository.ExampleRepositoryImpl
import com.example.data.util.ConnectivityManagerNetworkMonitor
import com.example.data.util.NetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    internal abstract fun bindsExampleRepository(
        exampleRepository: ExampleRepositoryImpl,
    ): ExampleRepository

    @Binds
    internal abstract fun bindsNetworkMonitor(
        networkMonitor: ConnectivityManagerNetworkMonitor,
    ): NetworkMonitor
}