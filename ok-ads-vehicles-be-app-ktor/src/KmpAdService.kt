package ru.otus.otuskotlin.ads_vehicles

import ru.otus.otuskotlin.ads_vehicles.backend.contexts.AdContext
import ru.otus.otuskotlin.ads_vehicles.storage.common.repositories.IAdRepository
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpAdCreateQuery
import ru.otus.otuskotlin.ads_vehicles.transport.models.ad.KmpAd
import ru.otus.otuskotlin.ads_vehicles.transport.multiplatform.backend.mappers.kmp
import ru.otus.otuskotlin.ads_vehicles.transport.multiplatform.backend.mappers.setQuery

class KmpAdService(
        private val adRepository: IAdRepository
) {
    suspend fun create(query: KmpAdCreateQuery): KmpAd = AdContext().run {
        this.setQuery(query)
        this.responseAd = this@KmpAdService.adRepository.create(this.requestAd!!)
        this.responseAd.kmp()
    }
}