rootProject.name = "RandomRoleplayPictures"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            val kotlin = version("kotlin", "1.6.21")
            val kotlinXSerialization = version("kotlinx-serialization", "1.3.2")
            val ktor = version("ktor", "2.0.0")
            val jib = version("jib", "3.2.1")

            library("kotlinx-coroutines-core", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").version("1.6.1")
            library("kotlin-logging", "io.github.microutils", "kotlin-logging").version("2.1.21")

            library("ktor-server-cio", "io.ktor", "ktor-server-cio").versionRef(ktor)
            library("ktor-server-compression", "io.ktor", "ktor-server-compression").versionRef(ktor)
            library("ktor-server-cachingheaders", "io.ktor", "ktor-server-caching-headers").versionRef(ktor)

            library("ktor-client-apache", "io.ktor", "ktor-client-apache").versionRef(ktor)

            library("kotlinx-serialization-core", "org.jetbrains.kotlinx", "kotlinx-serialization-core").versionRef(kotlinXSerialization)
            library("kotlinx-serialization-json", "org.jetbrains.kotlinx", "kotlinx-serialization-json").versionRef(kotlinXSerialization)
        }
    }
}

include(":common")
include(":client")
include(":backend")