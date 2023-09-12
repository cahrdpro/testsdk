pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()

    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(
            url ="https://oss.sonatype.org/content/repositories/ksoap2-android-releases/"
        )
    }
}

rootProject.name = "testsdk"
include(":app")
include(":urovosdk")
include(":olipaysdk")
include(":nexgosdk")
