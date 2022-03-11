plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 21
        targetSdk = 31

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField(
            "String",
            "BASE_API_URL",
            "\"https://virtserver.swaggerhub.com/m-tul/opn-mobile-challenge-api/1.0.0/\""
        )
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(libs.bundles.retrofit)
    implementation(libs.koin)
}