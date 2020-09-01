package ru.otus.otuskotlin.ads_vehicles.backend.models

import ru.otus.otuskotlin.ads_vehicles.backend.EnumMapper

enum class Engine {
    PETROL,
    DIESEL,
    PETROL_BOOSTED,
    DIESEL_BOOSTED,
    ELECTRIC;

    companion object : EnumMapper<Engine> {
        override fun displayName(enum: Engine): String =
                when (enum) {
                    PETROL -> "Бензин"
                    DIESEL -> "Дизель"
                    PETROL_BOOSTED -> "Бензин, наддув"
                    DIESEL_BOOSTED -> "Дизель, наддув"
                    ELECTRIC -> "Электро"
                }
    }
}