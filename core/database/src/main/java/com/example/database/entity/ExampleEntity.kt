package com.example.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "example")
data class ExampleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 1,
    val title: String,
    val description: String
)


