package ru.otus.otuskotlin.ads_vehicles.transport.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
abstract class KmpAdSave(
        @Transient open var year: Int? = null,
        @Transient open var modelId: String? = null,
        @Transient open var mileage: Int? = null,
        @Transient open var engine: String? = null,
        @Transient open var engineCC: Int? = null,
        @Transient open var powerHP: Int? = null,
        @Transient open var powerKW: Int? = null,
        @Transient open var torqueNM: Int? = null,
        @Transient open var gearbox: String? = null,
        @Transient open var drive: String? = null,
        @Transient open var steeringWheel: String? = null,
        @Transient open var chassis: String? = null,
        @Transient open var doors: Int? = null,
        @Transient open var colour: String? = null,
        @Transient open var owners: Int? = null,
        @Transient open var vin: String? = null,
        @Transient open var licensePlate: String? = null,
        @Transient open var price: Int? = null,
        @Transient open var userId: String? = null
)