package com.example.androidarchitecturetemplate.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.androidarchitecturetemplate.navigation.BaseNavHost
import com.example.feature.NavRouter

@Composable
fun BaseApp(
    modifier: Modifier = Modifier,
    appState: BaseAppState
) {
    var hasPreviousBackStackEntry: Boolean by remember { mutableStateOf(false) }

    LaunchedEffect(appState.currentDestination) {
        hasPreviousBackStackEntry =
            appState.navController.previousBackStackEntry != null
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = NavRouter.findNavRouterByRouteName(
                            appState.currentDestination?.route
                        )?.titleId?.let {
                            stringResource(id = it)
                        } ?: ""
                    )
                },
                navigationIcon = if (hasPreviousBackStackEntry) {
                    {
                        IconButton(
                            onClick = { appState.navController.popBackStack() }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                contentDescription = null
                            )
                        }
                    }
                } else null
            )
        },
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