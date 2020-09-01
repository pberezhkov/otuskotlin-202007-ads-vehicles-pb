package ru.otus.otuskotlin.ads_vehicles.backend.models

import ru.otus.otuskotlin.ads_vehicles.backend.EnumMapper

enum class Gearbox {
    MANUAL,
    AUTO,
    ROBOT,
    DCT,
    CVT,
    NONE;

    companion object : EnumMapper<Gearbox> {
        override fun displayName(enum: Gearbox): String =
                when (enum) {
                    MANUAL -> "Механика"
                    AUTO -> "Автомат"
                    ROBOT -> "Робот"
                    DCT -> "Робот с двумя сцеплениями"
                    CVT -> "Вариатор"
                    NONE -> "Прямая передача"
                }
    }
}