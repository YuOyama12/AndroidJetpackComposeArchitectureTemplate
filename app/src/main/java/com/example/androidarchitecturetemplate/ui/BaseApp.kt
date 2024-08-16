package com.example.androidarchitecturetemplate.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import com.example.androidarchitecturetemplate.navigation.BaseNavHost
import com.example.androidarchitecturetemplate.navigation.TopLevelDestinationType
import com.example.feature.NavRouter

@Composable
fun BaseApp(
    modifier: Modifier = Modifier,
    appState: BaseAppState
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = if (appState.currentTopLevelDestination != null) {
                            appState.currentTopLevelDestination?.titleId?.let {
                                stringResource(id = it)
                            } ?: ""
                        } else {
                            NavRouter.findNavRouterByRouteName(
                                appState.currentDestination?.route
                            )?.titleId?.let {
                                stringResource(id = it)
                            } ?: ""
                        }
                    )
                },
                navigationIcon =
                if (
                    appState.currentTopLevelDestination == null
                    || NavRouter.findNavRouterByRouteName(appState.currentDestination?.route)
                        ?.showBackButton == true
                    ) {
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
        bottomBar = {
            if (
                (appState.currentTopLevelDestination == null &&
                !appState.currentDestination.isInTopLevelDestination())
                || TopLevelDestinationType.entries.isEmpty()
                ) {
                return@Scaffold
            }

            BottomNavigation {
                TopLevelDestinationType.entries.forEach { destination->
                    val selected = appState.currentTopLevelDestination == destination
                    BottomNavigationItem(
                        selected = selected,
                        onClick = { appState.navigateToTopLevelDestination(destination) },
                        icon = {
                            Icon(
                                imageVector =
                                if (selected) destination.selectedIcon
                                else destination.unselectedIcon,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(text = stringResource(destination.titleId))
                        }
                    )
                }
            }
        }
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

private fun NavDestination?.isInTopLevelDestination(): Boolean =
    // 画面遷移時に一瞬routeがnullを返し、bottomNavigationBarが
    // 点滅するため、null時にはtrueとみなす。
    this?.route?.let { currentRoute ->
        TopLevelDestinationType.entries.any {
            it.route == currentRoute
        }
    } ?: true

