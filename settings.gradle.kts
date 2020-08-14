rootProject.name = "otuskotlin-202007-ads-vehicles-pb"

pluginManagement {
    plugins {
        val kotlinVersion: String by settings
        kotlin("jvm") version kotlinVersion
    }
}
include("ok-ads-vehicles-mp-transport-models")
