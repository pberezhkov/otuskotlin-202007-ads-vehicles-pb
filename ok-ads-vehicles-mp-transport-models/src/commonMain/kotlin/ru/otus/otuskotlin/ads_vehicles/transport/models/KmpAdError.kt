package ru.otus.otuskotlin.ads_vehicles.transport.models

import kotlinx.serialization.Serializable

@Serializable
data class KmpAdError(
        val code: Int? = null,
        val message: String? = null
)