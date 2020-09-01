package ru.otus.otuskotlin.ads_vehicles.backend.models

import ru.otus.otuskotlin.ads_vehicles.backend.EnumMapper

enum class Colour {
    BLACK,
    WHITE,
    GRAY,
    RED,
    BLUE,
    GREEN,
    YELLOW,
    ORANGE,
    PURPLE;

    companion object : EnumMapper<Colour> {
        override fun displayName(enum: Colour): String =
            when (enum) {
                BLACK -> "Чёрный"
                WHITE -> "Белый"
                GRAY -> "Серый"
                RED -> "Красный"
                BLUE -> "Синий"
                GREEN -> "Зелёный"
                YELLOW -> "Жёлтый"
                ORANGE -> "Оранжевый"
                PURPLE -> "Фиолетовый"
            }
    }
}