package ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle

import java.util.*

/**
 * Vehicle make
 */
data class Make (
        /**
         * ID
         */
        val id: String? = null,

        /**
         * Name
         */
        val name: String? = null,

        /**
         * ISO country code
         */
        val isoCountry: Locale.IsoCountryCode? = null
) {
    companion object {
        val NONE: Make = Make()
    }
}