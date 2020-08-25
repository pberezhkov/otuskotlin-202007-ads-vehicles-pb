rootProject.name = "otuskotlin-ads-vehicles"

pluginManagement {
    plugins {
        val kotlinVersion: String by settings
        kotlin("jvm") version kotlinVersion apply false
        kotlin("multiplatform") version kotlinVersion apply false
        kotlin("plugin.serialization") version kotlinVersion apply false
    }
}

include(":ok-ads-vehicles-mp-transport-models")
include("ok-ads-vehicles-be-common")
