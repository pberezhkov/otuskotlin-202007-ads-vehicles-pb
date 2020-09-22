package ru.otus.otuskotlin.ads_vehicles.transport.models

import kotlinx.serialization.Serializable

@Serializable
data class KmpAdListResponse(
        val data: List<KmpAd>? = null,
        val limit: Long? = null,
        val offset: Long? = null,
        override val status: KmpAdResponseStatus? = null,
        override val errors: List<KmpAdError>? = null
): KmpAdResponse(status = status, errors = errors)