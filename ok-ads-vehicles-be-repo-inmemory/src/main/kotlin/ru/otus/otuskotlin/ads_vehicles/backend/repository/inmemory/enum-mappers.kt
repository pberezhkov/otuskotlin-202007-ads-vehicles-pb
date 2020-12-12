package ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.enums.EngineLayout
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.enums.EngineType

fun EngineType.toByte(): Byte = when (this) {
    EngineType.PETROL -> 1.toByte()
    EngineType.DIESEL -> 2.toByte()
    EngineType.HYBRID -> 3.toByte()
    EngineType.ELECTRIC -> 4.toByte()
}

fun EngineType.Companion.of(value: Byte): EngineType = when (value) {
    1.toByte() -> EngineType.PETROL
    2.toByte() -> EngineType.DIESEL
    3.toByte() -> EngineType.HYBRID
    4.toByte() -> EngineType.ELECTRIC
    else -> EngineType.PETROL
}

fun EngineLayout.toByte(): Byte = when (this) {
    EngineLayout.FRONT_STRAIGHT -> 1.toByte()
    EngineLayout.FRONT_TRANSVERSED -> 2.toByte()
    EngineLayout.MID_STRAIGHT -> 3.toByte()
    EngineLayout.MID_TRANSVERSED -> 4.toByte()
    EngineLayout.REAR_STRAIGHT -> 5.toByte()
    EngineLayout.REAR_TRANSVERSED -> 6.toByte()
}

fun EngineLayout.Companion.of(value: Byte): EngineLayout = when (value) {
    1.toByte() -> EngineLayout.FRONT_STRAIGHT
    2.toByte() -> EngineLayout.FRONT_TRANSVERSED
    3.toByte() -> EngineLayout.MID_STRAIGHT
    4.toByte() -> EngineLayout.MID_TRANSVERSED
    5.toByte() -> EngineLayout.REAR_STRAIGHT
    6.toByte() -> EngineLayout.REAR_TRANSVERSED
    else -> EngineLayout.FRONT_STRAIGHT
}