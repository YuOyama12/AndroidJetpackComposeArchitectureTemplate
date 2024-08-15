package com.example.androidarchitecturetemplate.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import com.example.androidarchitecturetemplate.navigation.BaseNavHost

@Composable
fun BaseApp(
    modifier: Modifier = Modifier,
    appState: BaseAppState
) {
    Scaffold(
        modifier = modifier,
        topBar = {},
        bottomBar = {}
    ) { innerPadding ->
          Box(
              modifier = Modifier
                  .fillMaxSize()
                  .padding(innerPadding)
          ) {
              BaseNavHost(appState = appState)
          }
    }
}