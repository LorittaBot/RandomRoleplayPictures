plugins {
    kotlin("multiplatform") version libs.versions.kotlin apply false
    kotlin("plugin.serialization") version libs.versions.kotlin apply false
}

allprojects {
    group = "net.perfectdreams.randomroleplaypictures"
    version = "1.0.1"

    repositories {
        mavenCentral()
        maven("https://repo.perfectdreams.net/")
    }
}