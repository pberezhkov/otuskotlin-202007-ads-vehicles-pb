package ru.otus.otuskotlin.ads_vehicles.transport.models

import kotlinx.serialization.Serializable

@Serializable
data class KmpAdCreate(
        override var year: Int? = null,
        override var modelId: String? = null,
        override var mileage: Int? = null,
        override var engine: String? = null,
        override var engineCC: Int? = null,
        override var powerHP: Int? = null,
        override var powerKW: Int? = null,
        override var torqueNM: Int? = null,
        override var gearbox: String? = null,
        override var drive: String? = null,
        override var steeringWheel: String? = null,
        override var chassis: String? = null,
        override var doors: Int? = null,
        override var colour: String? = null,
        override var owners: Int? = null,
        override var vin: String? = null,
        override var licensePlate: String? = null,
        override var price: Int? = null,
        override var userId: String? = null
) : KmpAdSave(
        year = year,
        modelId = modelId,
        mileage = mileage,
        engine = engine,
        engineCC = engineCC,
        powerHP = powerHP,
        powerKW = powerKW,
        torqueNM = torqueNM,
        gearbox = gearbox,
        drive = drive,
        steeringWheel = steeringWheel,
        chassis = chassis,
        doors = doors,
        colour = colour,
        owners = owners,
        vin = vin,
        licensePlate = licensePlate,
        price = price,
        userId = userId
)