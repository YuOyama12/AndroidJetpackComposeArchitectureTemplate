package com.example.domain

import com.example.data.repository.ExampleRepository
import javax.inject.Inject

class ExampleUseCase @Inject constructor(
    private val exampleRepository: ExampleRepository
) {
}