package net.perfectdreams.randomroleplaypictures.backend.utils.pictures

import java.io.File

fun main() {
    val type = "MaleXMaleGenderMatchType"

    File("C:\\Users\\Leonardo\\Documents\\IdeaProjects\\RandomRoleplayPictures\\backend\\src\\main\\resources\\actions\\kiss\\drive-download-20220511T033316Z-001").listFiles()?.forEach {
        if (it.name.startsWith("_")) {
            println("picture(\"${it.name}\", $type)")
        } else {
            println("picture(\"${it.name}\", $type) {\nsource = AnimeSource(\"${it.name}\")\n}")
        }
    }
}