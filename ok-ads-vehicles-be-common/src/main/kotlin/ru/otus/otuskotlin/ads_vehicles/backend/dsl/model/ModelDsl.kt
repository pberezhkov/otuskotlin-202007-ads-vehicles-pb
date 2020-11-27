package ru.otus.otuskotlin.ads_vehicles.backend.dsl.model

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Make
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Model
import java.util.*

@ModelDslMarker
class ModelDsl {
    private var id: String = ""
    private var make: Make = Make.NONE
    private var name: String = ""


    public fun build(): Model = Model(
            id = this.id.takeIf { it.isNotBlank() } ?: UUID.randomUUID().toString(),
            make = this.make,
            name = this.name
    )

    public fun id(lambda: () -> String): Unit {
        this.id = lambda()
    }

    public fun make(lambda: () -> Make): Unit {
        this.make = lambda()
    }

    public fun name(lambda: () -> String): Unit {
        this.name = lambda()
    }
}

fun model(conf: ModelDsl.() -> Unit) = ModelDsl().apply(conf).build()