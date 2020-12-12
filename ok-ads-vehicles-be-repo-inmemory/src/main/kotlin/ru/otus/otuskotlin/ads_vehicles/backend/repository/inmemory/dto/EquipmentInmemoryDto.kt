package ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.dto

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Equipment
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Generation
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.enums.EngineLayout
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.enums.EngineType
import ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.of
import ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.toByte

data class EquipmentInmemoryDto(
        val id: String? = null,
        val generationId: String? = null,
        val name: String? = null,
        val engineType: Byte? = null,
        val engineLayout: Byte? = null,
        val boostType: Byte? = null,
        val engineCC: Int? = null,
        val engineCylinderLayout: Byte? = null,
        val engineCylinders: Int? = null,
        val enginePowerHP: Int? = null,
        val gearboxType: Byte? = null,
        val gears: Int? = null,
        val driveType: Byte? = null,
        val steeringWheel: Byte? = null,
        val chassisType: Byte? = null
) {
    fun model(generation: Generation): Equipment = Equipment(
            id = this.id,
            generation = generation,
            engineType = this.engineType?.let { EngineType.of(it) },
            engineLayout = this.engineLayout?.let { EngineLayout.of(it) }
    )

    companion object {
        fun of(equipment: Equipment): EquipmentInmemoryDto = of(equipment, equipment.id)
        fun of(equipment: Equipment, id: String?): EquipmentInmemoryDto = EquipmentInmemoryDto(
                id = id,
                generationId = equipment.generation.id,
                name = equipment.name,
                engineType = equipment.engineType?.toByte(),
                engineLayout = equipment.engineLayout?.toByte()
        )
    }
}
