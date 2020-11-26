package ru.otus.otuskotlin.ads_vehicles.backend.dsl.make

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Make

@MakeDslMarker
class MakeDsl {
    var id: String = ""
    private var name: MakeNameDsl = MakeNameDsl.EMPTY
    private var isoCountryCode: MakeIsoCountryCodeDsl = MakeIsoCountryCodeDsl.EMPTY


    public fun build(): Make = Make(
            id = this.id,
            name = this.name.name,
            isoCountryCode = this.isoCountryCode.isoCountryCode
    )

    public fun name(conf: MakeNameDsl.() -> Unit): Unit {
        this.name = MakeNameDsl().apply(conf)
    }

    public fun isoCountryCode(conf: MakeIsoCountryCodeDsl.() -> Unit): Unit {
        this.isoCountryCode = MakeIsoCountryCodeDsl().apply(conf)
    }
}

fun make(conf: MakeDsl.() -> Unit) = MakeDsl().apply(conf).build()