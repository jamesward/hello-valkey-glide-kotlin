pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

plugins {
    id("com.jamesward.kotlin-universe-catalog") version "2024.07.08-2"
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
