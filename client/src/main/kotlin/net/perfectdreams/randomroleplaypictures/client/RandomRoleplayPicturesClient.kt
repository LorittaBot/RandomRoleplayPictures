package net.perfectdreams.randomroleplaypictures.client

import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import net.perfectdreams.randomroleplaypictures.common.Gender
import net.perfectdreams.randomroleplaypictures.common.data.api.PictureResponse
import java.io.Closeable

class RandomRoleplayPicturesClient(
    baseUrl: String
) : Closeable {
    private val http = HttpClient(Apache) {}

    val baseUrl = baseUrl.removeSuffix("/") // Remove trailing slash

    suspend fun hug(gender1: Gender, gender2: Gender): PictureResponse {
        return Json.decodeFromString(
            http.get("$baseUrl/api/v1/actions/hug") {
                parameter("gender1", gender1.toString())
                parameter("gender2", gender2.toString())
            }.bodyAsText()
        )
    }

    suspend fun headPat(gender1: Gender, gender2: Gender): PictureResponse {
        return Json.decodeFromString(
            http.get("$baseUrl/api/v1/actions/head-pat") {
                parameter("gender1", gender1.toString())
                parameter("gender2", gender2.toString())
            }.bodyAsText()
        )
    }

    suspend fun highFive(gender1: Gender, gender2: Gender): PictureResponse {
        return Json.decodeFromString(
            http.get("$baseUrl/api/v1/actions/high-five") {
                parameter("gender1", gender1.toString())
                parameter("gender2", gender2.toString())
            }.bodyAsText()
        )
    }

    suspend fun slap(gender1: Gender, gender2: Gender): PictureResponse {
        return Json.decodeFromString(
            http.get("$baseUrl/api/v1/actions/slap") {
                parameter("gender1", gender1.toString())
                parameter("gender2", gender2.toString())
            }.bodyAsText()
        )
    }

    suspend fun attack(gender1: Gender, gender2: Gender): PictureResponse {
        return Json.decodeFromString(
            http.get("$baseUrl/api/v1/actions/attack") {
                parameter("gender1", gender1.toString())
                parameter("gender2", gender2.toString())
            }.bodyAsText()
        )
    }

    suspend fun dance(gender1: Gender, gender2: Gender): PictureResponse {
        return Json.decodeFromString(
            http.get("$baseUrl/api/v1/actions/dance") {
                parameter("gender1", gender1.toString())
                parameter("gender2", gender2.toString())
            }.bodyAsText()
        )
    }

    override fun close() {
        http.close()
    }
}