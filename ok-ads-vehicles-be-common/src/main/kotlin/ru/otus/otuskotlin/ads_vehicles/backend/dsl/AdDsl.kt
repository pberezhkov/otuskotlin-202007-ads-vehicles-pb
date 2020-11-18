package ru.otus.otuskotlin.ads_vehicles.backend.dsl

import ru.otus.otuskotlin.ads_vehicles.backend.models.Ad

@AdDslMarker
class AdDsl {
    public fun build(): Ad = Ad(

    )
}

fun ad(conf: AdDsl.() -> Unit) = AdDsl().apply(conf).build()