package ru.otus.otuskotlin.ads_vehicles.backend.models

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Equipment
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Generation
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Make
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Model
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.enums.*
import java.awt.Color
import java.time.*

/**
 * Ad
 */
data class Ad (
        /**
         * ID
         */
        val id: String? = null,

        /**
         * Vehicle production year
         */
        val year: Year? = null,

        /**
         * Vehicle mileage
         */
        val mileage: Mileage = Mileage.NONE,

        /**
         * Owners count
         */
        val owners: Int? = null,

        /**
         * Price
         */
        val price: MoneyAmount = MoneyAmount.NONE,

        /**
         * VIN
         */
        val vin: String? = null,

        /**
         * License plate
         */
        val licensePlate: String? = null,

        /**
         * Vehicle colour
         */
        val colour: Color? = null,

        /**
         * Make
         */
        val make: Make = Make.NONE,

        /**
         * Model
         */
        val model: Model = Model.NONE,

        /**
         * Generation
         */
        val generation: Generation = Generation.NONE,

        /**
         * Equipment
         */
        val equipment: Equipment = Equipment.NONE,

        /**
         * Repair requirement flag
         */
        val needsRepair: Boolean? = null,

        /**
         * Vehicle pictures
         */
        val pictures: ArrayList<Picture>? = null,

        /**
         * User-defined vehicle description
         */
        val description: String? = null,

        /**
         * User
         */
        val user: User = User.NONE,

        /**
         * Ad date
         */
        val date: LocalDate? = null,

        /**
         * Activity flag
         */
        val isActive: Boolean? = null
) {
    companion object {
        val NONE: Ad = Ad()
    }
}