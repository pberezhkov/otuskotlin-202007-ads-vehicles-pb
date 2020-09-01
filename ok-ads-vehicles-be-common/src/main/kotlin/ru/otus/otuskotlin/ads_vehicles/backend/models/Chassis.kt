package ru.otus.otuskotlin.ads_vehicles.backend.models

import ru.otus.otuskotlin.ads_vehicles.backend.EnumMapper

enum class Chassis {
    COUPE,
    SEDAN,
    CONVERTIBLE,
    LIFTBACK,
    HATCHBACK,
    ROADSTER;

    companion object : EnumMapper<Chassis> {
        override fun displayName(enum: Chassis): String =
                when (enum) {
                    COUPE -> "Купе"
                    SEDAN -> "Седан"
                    CONVERTIBLE -> "Кабриолет"
                    LIFTBACK -> "Лифтбек"
                    HATCHBACK -> "Хетчбек"
                    ROADSTER -> "Родстер"
                }
    }
}