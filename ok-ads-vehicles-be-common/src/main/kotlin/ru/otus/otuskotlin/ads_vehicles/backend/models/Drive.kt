package ru.otus.otuskotlin.ads_vehicles.backend.models

import ru.otus.otuskotlin.ads_vehicles.backend.EnumMapper

enum class Drive {
    RWD,
    FWD,
    FULL_TIME_AWD,
    PART_TIME_AWD;

    companion object : EnumMapper<Drive> {
        override fun displayName(enum: Drive): String =
                when (enum) {
                    RWD -> "Задний"
                    FWD -> "Передний"
                    FULL_TIME_AWD -> "Полный, постоянный"
                    PART_TIME_AWD -> "Полный, подключаемый"
                }
    }
}