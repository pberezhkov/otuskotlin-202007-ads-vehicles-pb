package ru.otus.otuskotlin.ads_vehicles.backend.contexts

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Make
import java.util.*

data class MakeContext(
        var requestMakeId: String? = null,
        var filter: Filter? = null,
        var responseMake: Make = Make.NONE,
        var responseMakeIndex: MutableList<Make> = mutableListOf()
) : AbstractContext() {
    data class Filter(
            val isoCountry: String? = null,
            val searchString: String? = null
    )
}