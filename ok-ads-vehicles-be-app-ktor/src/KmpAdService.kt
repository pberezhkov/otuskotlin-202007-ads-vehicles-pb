package ru.otus.otuskotlin.ads_vehicles

import ru.otus.otuskotlin.ads_vehicles.backend.contexts.MakeContext
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Make
import ru.otus.otuskotlin.ads_vehicles.backend.repositories.IMakeRepository
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpMakeIndexQuery
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpMakeIndexResponse
import ru.otus.otuskotlin.ads_vehicles.transport.multiplatform.backend.mappers.responseIndex
import ru.otus.otuskotlin.ads_vehicles.transport.multiplatform.backend.mappers.setQuery

class KmpAdService(
        private val makeRepository: IMakeRepository
) {
    suspend fun indexMake(query: KmpMakeIndexQuery): KmpMakeIndexResponse = MakeContext().run {
        this.setQuery(query)

        this.responseMakeIndex = this@KmpAdService.makeRepository.index(this.filter).toMutableList()

        this.responseIndex()
    }
}