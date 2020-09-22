package ru.otus.otuskotlin.ads_vehicles.transport.models

import kotlinx.serialization.Serializable

@Serializable
data class KmpAdSingleResponse(
        val data: KmpAd? = null,
        override val status: KmpAdResponseStatus? = null,
        override val errors: List<KmpAdError>? = null
): KmpAdResponse(status = status, errors = errors)