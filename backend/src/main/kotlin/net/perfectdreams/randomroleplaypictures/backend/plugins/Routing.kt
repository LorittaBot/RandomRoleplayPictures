package net.perfectdreams.randomroleplaypictures.backend.plugins

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import net.perfectdreams.randomroleplaypictures.backend.RandomRoleplayPictures
import net.perfectdreams.randomroleplaypictures.backend.routes.RoleplayRoute
import net.perfectdreams.sequins.ktor.BaseRoute

fun Application.configureRouting(m: RandomRoleplayPictures, routes: List<BaseRoute>) {
    routing {
        for (route in routes) {
            if (route is RoleplayRoute) {
                for (picture in route.pictures.pictures) {
                    static("img") {
                        resource("${picture.hash}.${picture.path.substringAfter(".")}", "actions/${route.pictures.path}/${picture.matchType.path}/${picture.path}")
                    }
                }
            }

            route.register(this)
        }
    }
}