package ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle

/**
 * Vehicle model
 */
data class Model (
        /**
         * ID
         */
        val id: String? = null,

        /**
         * Make
         */
        val make: Make = Make.NONE,

        /**
         * Name
         */
        val name: String? = null
) {
    companion object {
        val NONE: Model = Model()
    }
}