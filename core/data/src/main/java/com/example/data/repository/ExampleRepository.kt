package com.example.data.repository

import com.example.database.dao.ExampleDao
import com.example.database.entity.ExampleEntity
import com.example.model.Example
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface ExampleRepository {
}

class ExampleRepositoryImpl @Inject constructor(
    private val exampleDao: ExampleDao,
) : ExampleRepository {
}