package com.example.database.util

import androidx.room.TypeConverter

abstract class BaseTypeConverter<From, To> {
    @TypeConverter
    abstract fun convert(value: From): To

    @TypeConverter
    abstract fun restore(value: To): From
}