package ru.otus.otuskotlin.ads_vehicles

import ru.otus.otuskotlin.ads_vehicles.backend.contexts.EquipmentContext
import ru.otus.otuskotlin.ads_vehicles.backend.contexts.GenerationContext
import ru.otus.otuskotlin.ads_vehicles.backend.contexts.MakeContext
import ru.otus.otuskotlin.ads_vehicles.backend.contexts.ModelContext
import ru.otus.otuskotlin.ads_vehicles.storage.common.repositories.*
import ru.otus.otuskotlin.ads_vehicles.transport.models.*
import ru.otus.otuskotlin.ads_vehicles.transport.multiplatform.backend.mappers.responseIndex
import ru.otus.otuskotlin.ads_vehicles.transport.multiplatform.backend.mappers.setQuery

class KmpStockService(
        private val makeRepository: IMakeRepository,
        private val modelRepository: IModelRepository,
        private val generationRepository: IGenerationRepository,
        private val equipmentRepository: IEquipmentRepository
) {
    suspend fun indexMake(query: KmpMakeIndexQuery): KmpMakeIndexResponse = MakeContext().run {
        this.setQuery(query)

        this.responseMakeIndex = this@KmpStockService.makeRepository.index(this.filter).toMutableList()

        this.responseIndex()
    }

    suspend fun indexModel(query: KmpModelIndexQuery): KmpModelIndexResponse = ModelContext().run {
        this.setQuery(query)

        this.responseModelIndex = this@KmpStockService.modelRepository.index(this.filter).toMutableList()

        this.responseIndex()
    }

    suspend fun indexGeneration(query: KmpGenerationIndexQuery): KmpGenerationIndexResponse = GenerationContext().run {
        this.setQuery(query)

        this.responseIndex = this@KmpStockService.generationRepository.index(this.filter).toMutableList()

        this.responseIndex()
    }

    suspend fun indexEquipment(query: KmpEquipmentIndexQuery): KmpEquipmentIndexResponse = EquipmentContext().run {
        this.setQuery(query)

        this.responseIndex = this@KmpStockService.equipmentRepository.index(this.filter).toMutableList()

        this.responseIndex()
    }
}