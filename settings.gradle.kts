rootProject.name = "RandomRoleplayPictures"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            val kotlin = version("kotlin", "2.2.21")
            val kotlinXSerialization = version("kotlinx-serialization", "1.9.0")
            val ktor = version("ktor", "3.3.2")
            val jib = version("jib", "3.4.5")

            library("kotlinx-coroutines-core", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").version("1.10.1")
            library("kotlin-logging", "io.github.microutils", "kotlin-logging").version("2.1.21")

            library("ktor-server-cio", "io.ktor", "ktor-server-cio").versionRef(ktor)
            library("ktor-server-compression", "io.ktor", "ktor-server-compression").versionRef(ktor)
            library("ktor-server-cachingheaders", "io.ktor", "ktor-server-caching-headers").versionRef(ktor)

            library("ktor-client-java", "io.ktor", "ktor-client-java").versionRef(ktor)

            library("kotlinx-serialization-core", "org.jetbrains.kotlinx", "kotlinx-serialization-core").versionRef(kotlinXSerialization)
            library("kotlinx-serialization-json", "org.jetbrains.kotlinx", "kotlinx-serialization-json").versionRef(kotlinXSerialization)
        }
    }
}

include(":common")
include(":client")
include(":backend")