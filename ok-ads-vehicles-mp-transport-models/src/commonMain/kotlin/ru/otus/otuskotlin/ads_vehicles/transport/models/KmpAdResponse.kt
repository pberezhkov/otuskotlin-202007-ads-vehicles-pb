package ru.otus.otuskotlin.ads_vehicles.transport.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
open class KmpAdResponse(
        @Transient open val status: KmpAdResponseStatus? = null,
        @Transient open val errors: List<KmpAdError>? = null
)