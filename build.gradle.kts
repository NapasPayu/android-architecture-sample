buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.gradle.plugin.android)
        classpath(libs.gradle.plugin.kotlin)
        classpath(libs.gradle.plugin.navigation)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
