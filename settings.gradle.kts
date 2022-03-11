dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("VERSION_CATALOGS")

rootProject.name = "ChallengeMobileSample"

include(
    ":app",
    ":data",
    ":domain",
    ":feature:store",
    ":feature:ordersuccess"
)