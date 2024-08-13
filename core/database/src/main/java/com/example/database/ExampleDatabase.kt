package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.database.dao.ExampleDao
import com.example.database.entity.ExampleEntity

@Database(
    entities = [ExampleEntity::class,],
    version = 1,
    exportSchema = true
)
internal abstract class ExampleDatabase : RoomDatabase() {
    abstract fun exampleDao(): ExampleDao
}