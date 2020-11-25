package ru.otus.otuskotlin.ads_vehicles.backend.contexts

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Generation

data class GenerationContext (
        var requestGenerationId: String? = null,
        var filter: Filter? = null,
        var responseGeneration: Generation = Generation.NONE,
        var responseIndex: MutableList<Generation> = mutableListOf()
) : AbstractContext(){
    data class Filter(
            val modelId: String? = null,
            val searchString: String? = null
    )
}