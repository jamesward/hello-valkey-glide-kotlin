plugins {
    application
    kotlin("jvm") version "2.0.20"
    //id("com.google.osdetector") version "1.7.3"
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
    implementation("io.valkey", "valkey-glide", "1.1.0") //, classifier = osdetector.classifier)

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")

    implementation("org.testcontainers:testcontainers:1.20.1")
    implementation("org.slf4j:slf4j-simple:2.0.16")
}
