package com.example.feature

sealed class NavRouter(val route: String) {
    sealed class Argument(val name: String) {}

    data object Home : NavRouter("home")

    data object Sub : NavRouter("sub")

    private fun String.createNavRouterWithArguments(args: List<Argument>): String {
        var route = "${this}/"

        args.forEach { arg ->
            route += "{${arg.name}}"

            if (arg != args.last()) {
                route += "/"
            }
        }

        return route
    }

    private fun NavRouter.createRouteWithArguments(args: Map<Argument, Any>): String {
        var route = "${this.route}/"


        args.forEach { arg ->
            route += arg.value.toString()

            if (arg.value != args.values.last()) {
                route += "/"
            }
        }

        return route
    }
}