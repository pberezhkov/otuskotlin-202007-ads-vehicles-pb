package ru.otus.otuskotlin.ads_vehicles.backend.contexts

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Equipment

data class EquipmentContext(
        var requestEquipmentId: String? = null,
        var filter: Filter? = null,
        var responseEquipment: Equipment = Equipment.NONE,
        var responseIndex: MutableList<Equipment> = mutableListOf()
) : AbstractContext() {
    data class Filter(
            val generationId: String? = null,
            val searchString: String? = null
    )
}