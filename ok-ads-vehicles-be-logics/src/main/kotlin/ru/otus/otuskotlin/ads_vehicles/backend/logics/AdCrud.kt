package ru.otus.otuskotlin.ads_vehicles.backend.logics

import ru.otus.otuskotlin.ads_vehicles.backend.contexts.AdContext
import ru.otus.otuskotlin.ads_vehicles.backend.logics.cor.ad.AdCreateChain
import ru.otus.otuskotlin.ads_vehicles.storage.common.repositories.IAdRepository
import ru.otus.otuskotlin.ads_vehicles.storage.common.repositories.IEquipmentRepository

class AdCrud private constructor(private val adCreateChain: AdCreateChain) {
    constructor(
            adRepository: IAdRepository,
            equipmentRepository: IEquipmentRepository
    ) : this(adCreateChain = AdCreateChain(
            adRepository = adRepository,
            equipmentRepository = equipmentRepository
    ))

    suspend fun create(ctx: AdContext) = this.adCreateChain.exec(ctx)
}