package com.example.androidarchitecturetemplate.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * 主にBottomNavigationBarによる遷移先をまとめたクラス。
 * 各画面からTopLevel以外の複数の画面に遷移することを想定している。
 */
enum class TopLevelDestinationType(
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    @StringRes val titleId: Int
) {
    Home(
        route = "home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        titleId = com.example.feature.R.string.home
    ),
}