plugins {
    application
    alias(universe.plugins.kotlin.jvm)
    id("com.google.osdetector") version "1.7.3"
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass = "MainKt"
}

dependencies {
    // might only work for linux-x86_64
    // see: https://github.com/valkey-io/valkey-glide/pull/1905#issuecomment-2219538070
    implementation("io.valkey", "valkey-glide", "1.0.0")

    implementation(universe.kotlinx.coroutines.core)

    implementation("org.testcontainers:testcontainers:1.19.8")
    implementation("org.slf4j:slf4j-simple:2.0.13")
}
