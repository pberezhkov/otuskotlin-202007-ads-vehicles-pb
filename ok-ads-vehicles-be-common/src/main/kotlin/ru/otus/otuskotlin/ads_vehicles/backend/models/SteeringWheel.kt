package ru.otus.otuskotlin.ads_vehicles.backend.models

import ru.otus.otuskotlin.ads_vehicles.backend.EnumMapper

enum class SteeringWheel {
    LEFT,
    RIGHT;

    companion object : EnumMapper<SteeringWheel> {
        override fun displayName(enum: SteeringWheel): String =
                when (enum) {
                    LEFT -> "Левый"
                    RIGHT -> "Правый"
                }

    }
}