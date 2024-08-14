package com.example.database.di

import android.content.Context
import androidx.room.Room
import com.example.database.ExampleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    @Provides
    @Singleton
    fun providesExampleDatabase(
        @ApplicationContext context: Context,
    ): ExampleDatabase = Room.databaseBuilder(
        context = context,
        klass = ExampleDatabase::class.java,
        name = "database"
    ).build()
}