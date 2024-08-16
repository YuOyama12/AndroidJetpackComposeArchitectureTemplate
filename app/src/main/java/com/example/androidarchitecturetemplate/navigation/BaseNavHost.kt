package com.example.androidarchitecturetemplate.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidarchitecturetemplate.ui.BaseAppState
import com.example.feature.NavRouter
import com.example.feature.home.HomeScreen
import com.example.feature.sub.SubScreen

@Composable
fun BaseNavHost(
    modifier: Modifier = Modifier,
    appState: BaseAppState
) {
    val navController = appState.navController

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = TopLevelDestinationType.Home.route
    ) {
        composable(TopLevelDestinationType.Home.route) {
            HomeScreen(
                navToSub = { navController.navigate(NavRouter.Sub.route) }
            )
        }
        composable(NavRouter.Sub.route) {
            SubScreen()
        }
    }
}