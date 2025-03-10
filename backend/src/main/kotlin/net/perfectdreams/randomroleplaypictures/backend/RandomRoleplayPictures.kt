package net.perfectdreams.randomroleplaypictures.backend

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import io.ktor.server.plugins.cachingheaders.*
import io.ktor.server.plugins.compression.*
import net.perfectdreams.randomroleplaypictures.backend.plugins.configureRouting
import net.perfectdreams.randomroleplaypictures.backend.routes.RoleplayRoute
import net.perfectdreams.randomroleplaypictures.backend.utils.pictures.*
import kotlin.concurrent.thread

class RandomRoleplayPictures {
    val routes = listOf(
        RoleplayRoute(HugRoleplayPictures),
        RoleplayRoute(HeadPatRoleplayPictures),
        RoleplayRoute(HighFiveRoleplayPictures),
        RoleplayRoute(SlapRoleplayPictures),
        RoleplayRoute(AttackRoleplayPictures),
        RoleplayRoute(DanceRoleplayPictures),
        RoleplayRoute(KissRoleplayPictures)
    )

    private val typesToCache = listOf(
        ContentType.Text.CSS,
        ContentType.Text.JavaScript,
        ContentType.Application.JavaScript,
        ContentType.Image.Any,
        ContentType.Video.Any
    )

    fun start() {
        val server = embeddedServer(CIO, 8080) {
            // Enables gzip and deflate compression
            install(Compression)

            // Enables caching for the specified types in the typesToCache list
            install(CachingHeaders) {
                options { _, outgoingContent ->
                    val contentType = outgoingContent.contentType
                    if (contentType != null) {
                        val contentTypeWithoutParameters = contentType.withoutParameters()
                        val matches = typesToCache.any { contentTypeWithoutParameters.match(it) || contentTypeWithoutParameters == it }

                        if (matches)
                            io.ktor.http.content.CachingOptions(CacheControl.MaxAge(maxAgeSeconds = 365 * 24 * 3600))
                        else
                            null
                    } else null
                }
            }

            configureRouting(this@RandomRoleplayPictures, routes)
        }.start(wait = true)

        Runtime.getRuntime().addShutdownHook(
            thread(false) {
                server.stop(15_000L, 15_000L)
            }
        )
    }
}