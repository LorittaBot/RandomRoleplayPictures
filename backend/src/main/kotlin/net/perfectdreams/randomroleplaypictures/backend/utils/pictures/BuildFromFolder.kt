package net.perfectdreams.randomroleplaypictures.backend.utils.pictures

import java.io.File

fun main() {
    File("L:\\LorittaAssets\\assets_folder\\assets\\actions\\kiss\\generic").listFiles()?.forEach {
        println("picture(\"${it.name}\", GenericMatchType)")
    }

    File("L:\\LorittaAssets\\assets_folder\\assets\\actions\\kiss\\both").listFiles()?.forEach {
        println("picture(\"${it.name}\", BothMatchType)")
    }

    File("L:\\LorittaAssets\\assets_folder\\assets\\actions\\kiss\\male_x_male").listFiles()?.forEach {
        println("picture(\"${it.name}\", MaleXMaleGenderMatchType)")
    }

    File("L:\\LorittaAssets\\assets_folder\\assets\\actions\\kiss\\male_x_female").listFiles()?.forEach {
        println("picture(\"${it.name}\", MaleXFemaleGenderMatchType)")
    }

    File("L:\\LorittaAssets\\assets_folder\\assets\\actions\\kiss\\female_x_male").listFiles()?.forEach {
        println("picture(\"${it.name}\", FemaleXMaleGenderMatchType)")
    }

    File("L:\\LorittaAssets\\assets_folder\\assets\\actions\\kiss\\female_x_female").listFiles()?.forEach {
        println("picture(\"${it.name}\", FemaleXFemaleGenderMatchType)")
    }
}