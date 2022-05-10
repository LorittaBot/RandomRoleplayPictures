plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

dependencies {
    implementation(project(":common"))
    implementation("commons-codec:commons-codec:1.15")

    implementation(libs.kotlinx.serialization.json)

    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.compression)
    implementation(libs.ktor.server.cachingheaders)
    implementation("net.perfectdreams.sequins.ktor:base-route:1.0.4")

    // Logging
    api("ch.qos.logback:logback-classic:1.3.0-alpha14")
}