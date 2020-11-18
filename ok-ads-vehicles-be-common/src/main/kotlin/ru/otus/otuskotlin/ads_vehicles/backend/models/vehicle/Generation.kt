package ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle

import java.time.Year

/**
 * Vehicle model generation
 */
data class Generation(
        /**
         * ID
         */
        val id: String? = null,

        /**
         * Model
         */
        val model: Model = Model.NONE,

        /**
         * Name
         */
        val name: String? = null,

        /**
         * Production beginning year
         */
        val yearFrom: Year? = null,

        /**
         * Production ending year
         */
        val yearTo: Year? = null
) {
    companion object {
        val NONE: Generation = Generation()
    }
}