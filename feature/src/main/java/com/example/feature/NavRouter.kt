package com.example.feature

import androidx.annotation.StringRes

/**
 * TopLevelDestination以外の遷移先をまとめたクラス
 */
sealed class NavRouter(
    val route: String,
    @StringRes val titleId: Int,
    val showBackButton: Boolean = true
) {
    companion object {
        private val entries = NavRouter::class.nestedClasses.mapNotNull {
            it.objectInstance as? NavRouter
        }

        fun findNavRouterByRouteName(route: String?): NavRouter? =
            entries.find { it.route == route }
    }

    sealed class Argument(val name: String) {}

    data object Sub : NavRouter(
        route = "sub",
        titleId = R.string.sub
    )
}


private fun String.createNavRouterWithArguments(args: List<NavRouter.Argument>): String {
    var result = "${this}/"

    args.forEach { arg ->
        result += "{${arg.name}}"

        if (arg != args.last()) {
            result += "/"
        }
    }

    return result
}

private fun NavRouter.createRouteWithArguments(args: Map<NavRouter.Argument, Any>): String {
    var result = this.route

    args.forEach { arg ->
        result = result.replace("{${arg.key.name}}", arg.value.toString())
    }

    return result
}