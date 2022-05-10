package net.perfectdreams.randomroleplaypictures.backend.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.util.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import net.perfectdreams.randomroleplaypictures.common.Gender
import net.perfectdreams.randomroleplaypictures.backend.utils.RoleplayPictures
import net.perfectdreams.randomroleplaypictures.common.data.api.PictureResponse
import net.perfectdreams.sequins.ktor.BaseRoute

open class RoleplayRoute(val pictures: RoleplayPictures) : BaseRoute("/api/v1/actions/${pictures.path}") {
    override suspend fun onRequest(call: ApplicationCall) {
        val gender1 = Gender.valueOf(call.parameters.getOrFail("gender1"))
        val gender2 = Gender.valueOf(call.parameters.getOrFail("gender2"))

        // Time to filter the pictures!
        val filteredPictures = pictures.pictures
            .filter {
                if (gender1 != Gender.UNKNOWN && gender2 != Gender.UNKNOWN) {
                    if (gender1 != gender2) {
                        (it.matchType is RoleplayPictures.GenderMatchType && (it.matchType.gender1 == gender1 && it.matchType.gender2 == gender2)) || it.matchType is RoleplayPictures.BothMatchType
                    } else {
                        (it.matchType is RoleplayPictures.GenderMatchType && (it.matchType.gender1 == gender1 && it.matchType.gender2 == gender2))
                    }
                } else {
                    // If someone has their gender set to "UNKNOWN"

                    // Here we actually check for || on the gender, because we only want to get any match, and because the gender match type doesn't have a "UNKNOWN" gender
                    (it.matchType is RoleplayPictures.GenderMatchType && (it.matchType.gender1 == gender1 || it.matchType.gender2 == gender2)) || (it.matchType is RoleplayPictures.GenericMatchType || it.matchType is RoleplayPictures.BothMatchType)
                }
            }

        // If the filteredPictures list is empty, select the full list
        val pictures = filteredPictures.ifEmpty { pictures.pictures }

        val picture = pictures.random()

        call.respondText(
            Json.encodeToString(
                PictureResponse(
                    picture.hash + "." + picture.path.substringAfter("."),
                    picture.source
                )
            ),
            ContentType.Application.Json
        )
    }
}