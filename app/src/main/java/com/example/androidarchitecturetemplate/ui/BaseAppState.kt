package com.example.androidarchitecturetemplate.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.androidarchitecturetemplate.navigation.TopLevelDestinationType
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberBaseAppState(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
): BaseAppState {
    return remember(
        navController,
        coroutineScope
    ) {
        BaseAppState(
            navController = navController,
            coroutineScope = coroutineScope
        )
    }
}

@Stable
class BaseAppState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestinationType?
        @Composable get() = TopLevelDestinationType.entries.find {
            it.route == currentDestination?.route
        }

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestinationType) {
        val topLevelNavOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        navController.navigate(topLevelDestination.route, navOptions = topLevelNavOptions)
    }
}