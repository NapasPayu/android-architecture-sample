plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "ooo.opn.challengemobilesample"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        dataBinding = true
    }

    dynamicFeatures += setOf(
        ":feature:store",
        ":feature:ordersuccess"
    )
}

dependencies {
    implementation(project(":data"))
    api(project(":domain"))
    implementation(libs.appcompat)
    implementation(libs.fragment)
    api(libs.core.ktx)
    api(libs.material)
    api(libs.koin)
    api(libs.coil)
    api(libs.coroutines)
    api(libs.recyclerview)
    api(libs.bundles.navigation)
    api(libs.bundles.lifecycle)
}