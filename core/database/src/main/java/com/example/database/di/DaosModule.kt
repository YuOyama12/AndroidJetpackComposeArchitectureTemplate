package com.example.database.di

import com.example.database.ExampleDatabase
import com.example.database.dao.ExampleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaosModule {
    @Provides
    fun providesTopicsDao(
        database: ExampleDatabase
    ): ExampleDao = database.exampleDao()
}