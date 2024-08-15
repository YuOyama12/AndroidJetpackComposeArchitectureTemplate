package com.example.androidarchitecturetemplate.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidarchitecturetemplate.ui.BaseAppState
import com.example.feature.NavRouter
import com.example.feature.home.HomeScreen

@Composable
fun BaseNavHost(
    modifier: Modifier = Modifier,
    appState: BaseAppState
) {
    val navController = appState.navController

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavRouter.Home.route
    ) {
        composable(NavRouter.Home.route) {
            HomeScreen()
        }
    }
}