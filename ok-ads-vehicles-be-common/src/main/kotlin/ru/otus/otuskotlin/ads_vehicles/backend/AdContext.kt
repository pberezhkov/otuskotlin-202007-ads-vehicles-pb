package ru.otus.otuskotlin.ads_vehicles.backend

import ru.otus.otuskotlin.ads_vehicles.backend.models.Ad

data class AdContext(
        var requestAdId: Int? = null,
        var requestAd: Ad? = null,
        var responseAd: Ad? = null,
        var status: AdContextStatus = AdContextStatus.NONE
)