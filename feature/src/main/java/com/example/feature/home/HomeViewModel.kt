package com.example.feature.home

import androidx.lifecycle.ViewModel
import com.example.domain.ExampleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val exampleUseCase: ExampleUseCase
) : ViewModel() {

}