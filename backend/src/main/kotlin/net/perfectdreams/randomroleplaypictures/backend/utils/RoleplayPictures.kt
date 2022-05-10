package net.perfectdreams.randomroleplaypictures.backend.utils

import net.perfectdreams.randomroleplaypictures.backend.RandomRoleplayPictures
import net.perfectdreams.randomroleplaypictures.common.Gender
import org.apache.commons.codec.binary.Hex
import java.nio.file.FileSystemNotFoundException
import java.nio.file.FileSystems
import java.nio.file.Path
import java.nio.file.Paths
import java.security.MessageDigest
import kotlin.io.path.exists
import kotlin.io.path.readBytes
import net.perfectdreams.randomroleplaypictures.common.data.api.PictureSource

abstract class RoleplayPictures(val path: String) {
    private val _pictures = mutableListOf<RoleplayPicture>()
    val pictures: List<RoleplayPicture> = _pictures

    fun picture(path: String, matchType: MatchType, builder: RoleplayPictureBuilder.() -> (Unit) = {}) {
        val resourcesPath = getPathFromResources("/actions/${this.path}/${matchType.path}/${path}")

        // Validates if the picture actually exists
        if (resourcesPath == null || !resourcesPath.exists())
            error("Picture \"/actions/${this.path}/${matchType.path}/$path\" is missing!")

        val digest = MessageDigest.getInstance("SHA-1").digest(resourcesPath.readBytes())

        _pictures.add(
            RoleplayPictureBuilder(
                path,
                matchType,
                Hex.encodeHexString(digest)
            ).apply(builder).build()
        )
    }

    class RoleplayPictureBuilder(val path: String, val matchType: MatchType, val hash: String) {
        var source: PictureSource? = null

        fun build() = RoleplayPicture(
            path,
            matchType,
            hash,
            source
        )
    }

    data class RoleplayPicture(
        val path: String,
        val matchType: MatchType,
        val hash: String,
        val source: PictureSource?
    )

    sealed class MatchType(val path: String)
    object GenericMatchType : MatchType("generic")
    object BothMatchType : MatchType("both")
    sealed class GenderMatchType(name: String, val gender1: Gender, val gender2: Gender) : MatchType(name)
    object MaleXMaleGenderMatchType : GenderMatchType("male-x-male", Gender.MALE, Gender.MALE)
    object FemaleXFemaleGenderMatchType : GenderMatchType("female-x-female", Gender.FEMALE, Gender.FEMALE)
    // Yes, they are the same thing but opposite, because the user that initiated the action also matters
    object MaleXFemaleGenderMatchType : GenderMatchType("male-x-female", Gender.MALE, Gender.FEMALE)
    object FemaleXMaleGenderMatchType : GenderMatchType("female-x-male", Gender.FEMALE, Gender.MALE)

    private fun getPathFromResources(path: String): Path? {
        // https://stackoverflow.com/a/67839914/7271796
        val resource = RandomRoleplayPictures::class.java.getResource(path) ?: return null
        val uri = resource.toURI()
        val dirPath = try {
            Paths.get(uri)
        } catch (e: FileSystemNotFoundException) {
            // If this is thrown, then it means that we are running the JAR directly (example: not from an IDE)
            val env = mutableMapOf<String, String>()
            FileSystems.newFileSystem(uri, env).getPath(path)
        }
        return dirPath
    }
}