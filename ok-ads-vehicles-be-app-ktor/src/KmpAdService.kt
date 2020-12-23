package ru.otus.otuskotlin.ads_vehicles

import ru.otus.otuskotlin.ads_vehicles.backend.GenericError
import ru.otus.otuskotlin.ads_vehicles.backend.contexts.AdContext
import ru.otus.otuskotlin.ads_vehicles.backend.contexts.ContextStatus
import ru.otus.otuskotlin.ads_vehicles.backend.logics.AdCrud
import ru.otus.otuskotlin.ads_vehicles.storage.common.repositories.IAdRepository
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpAdCreateQuery
import ru.otus.otuskotlin.ads_vehicles.transport.models.ad.KmpAd
import ru.otus.otuskotlin.ads_vehicles.transport.multiplatform.backend.mappers.kmp
import ru.otus.otuskotlin.ads_vehicles.transport.multiplatform.backend.mappers.setQuery

class KmpAdService(
        private val adCrud: AdCrud
) {
    suspend fun create(query: KmpAdCreateQuery): KmpAd = AdContext().run {
        try {
            this@KmpAdService.adCrud.create(this.setQuery(query))
        } catch (e: Throwable) {
            this.status = ContextStatus.FAILURE
            this.errors.add(GenericError(message = e.message, originalException = e))
        }

        this.responseAd.kmp()
    }
}