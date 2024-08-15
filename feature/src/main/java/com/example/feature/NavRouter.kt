package com.example.feature

sealed class NavRouter(val route: String) {
    sealed class Argument(val name: String) {}

    data object Home : NavRouter("home")

    data object Sub : NavRouter("sub")
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