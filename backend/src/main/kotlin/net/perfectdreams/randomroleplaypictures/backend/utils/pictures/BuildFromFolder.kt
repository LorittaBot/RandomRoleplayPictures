package net.perfectdreams.randomroleplaypictures.backend.utils.pictures

import java.io.File

fun main() {
    File("C:\\Users\\Leonardo\\Documents\\IdeaProjects\\RandomRoleplayPictures\\backend\\src\\main\\resources\\actions\\kiss\\generic").listFiles()?.forEach {
        println("picture(\"${it.name}\", GenericMatchType)")
    }

    File("C:\\Users\\Leonardo\\Documents\\IdeaProjects\\RandomRoleplayPictures\\backend\\src\\main\\resources\\actions\\kiss\\both").listFiles()?.forEach {
        println("picture(\"${it.name}\", BothMatchType)")
    }

    File("C:\\Users\\Leonardo\\Documents\\IdeaProjects\\RandomRoleplayPictures\\backend\\src\\main\\resources\\actions\\kiss\\male-x-male").listFiles()?.forEach {
        println("picture(\"${it.name}\", MaleXMaleGenderMatchType)")
    }

    File("C:\\Users\\Leonardo\\Documents\\IdeaProjects\\RandomRoleplayPictures\\backend\\src\\main\\resources\\actions\\kiss\\male-x-female").listFiles()?.forEach {
        println("picture(\"${it.name}\", MaleXFemaleGenderMatchType)")
    }

    File("C:\\Users\\Leonardo\\Documents\\IdeaProjects\\RandomRoleplayPictures\\backend\\src\\main\\resources\\actions\\kiss\\female-x-male").listFiles()?.forEach {
        println("picture(\"${it.name}\", FemaleXMaleGenderMatchType)")
    }

    File("C:\\Users\\Leonardo\\Documents\\IdeaProjects\\RandomRoleplayPictures\\backend\\src\\main\\resources\\actions\\kiss\\female-x-female").listFiles()?.forEach {
        println("picture(\"${it.name}\", FemaleXFemaleGenderMatchType)")
    }
}