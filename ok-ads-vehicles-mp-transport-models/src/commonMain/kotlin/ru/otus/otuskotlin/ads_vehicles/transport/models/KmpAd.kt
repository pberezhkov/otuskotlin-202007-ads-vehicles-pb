package ru.otus.otuskotlin.ads_vehicles.transport.models

import kotlinx.serialization.Serializable

@Serializable
data class KmpAd (
        var id: String? = null,
        var year: Int? = null,
        var make: String? = null,
        var model: String? = null,
        var mileage: Int? = null,
        var engine: String? = null,
        var engineCC: Int? = null,
        var powerHP: Int? = null,
        var powerKW: Int? = null,
        var torqueNM: Int? = null,
        var gearbox: String? = null,
        var drive: String? = null,
        var steeringWheel: String? = null,
        var chassis: String? = null,
        var doors: Int? = null,
        var colour: String? = null,
        var owners: Int? = null,
        var vin: String? = null,
        var licensePlate: String? = null,
        var price: Int? = null,
        var userId: String? = null
)