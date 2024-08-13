package com.example.database.di

import android.content.Context
import androidx.room.Room
import com.example.database.ExampleDatabase
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

internal object DatabaseModule {
    @Provides
    @Singleton
    fun providesNiaDatabase(
        @ApplicationContext context: Context,
    ): ExampleDatabase = Room.databaseBuilder(
        context = context,
        klass = ExampleDatabase::class.java,
        name = "database"
    ).build()
}