pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "FakeProductsApp"
include(":app", "core", "feature")
include(":core:feature-api")
include(":feature:productlist-api")
include(":feature:favoriteproducts-api")
include(":feature:productcard-api")
include(":feature:productlist-impl")
include(":feature:productcard-impl")
include(":feature:favoriteproducts-impl")
include(":core:di")
