package ru.otus.otuskotlin.ads_vehicles.backend.models

import java.time.*

data class Ad (
        val id: String,
        val year: Year,
        val model: Model,
        val mileage: Int,
        val engine: Engine,
        val engineCC: Int,
        val powerHP: Int,
        val powerKW: Int,
        val torqueNM: Int,
        val gearbox: Gearbox,
        val drive: Drive,
        val steeringWheel: SteeringWheel,
        val chassis: Chassis,
        val doors: Int,
        val colour: Colour,
        val owners: Int?,
        val vin: String?,
        val licensePlate: String?,
        val price: Int
)