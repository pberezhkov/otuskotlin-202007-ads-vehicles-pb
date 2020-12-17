package ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.dto

import ru.otus.otuskotlin.ads_vehicles.backend.models.ad.Ad
import ru.otus.otuskotlin.ads_vehicles.backend.models.ad.Mileage
import java.time.Year

@OptIn(ExperimentalUnsignedTypes::class)
data class AdInmemoryDto(
        val id: String? = null,
        val year: UShort? = null,
        val mileageValue: UInt? = null,
        val mileageUnit: UByte? = null,
        val owners: UByte? = null,
        val priceAmount: UInt? = null,
        val priceCurrency: String? = null,
        val vin: String? = null,
        val licensePlate: String? = null,
        val colour: UInt? = null,
        val makeId: String? = null,
        val modelId: String? = null,
        val generationId: String? = null,
        val equipment: String? = null,
        val needsRepair: Boolean? = null,
        val pictureIds: List<String>? = null,
        val description: String? = null,
        val userId: String? = null,
        val date: String? = null,
        val isActive: Boolean? = null
) {
    companion object {
        fun of(ad: Ad): AdInmemoryDto = of(ad, ad.id)
        fun of(ad: Ad, id: String?): AdInmemoryDto = AdInmemoryDto(
                id = id,
                year = ad.year?.value?.toUShort(),
                mileageValue = ad.mileage.value?.toUInt(),
                mileageUnit = ad.mileage.unit?.let { when (it) {
                        Mileage.MileageUnit.KM -> 1
                        Mileage.MileageUnit.MI -> 2
                    }.toUByte()
                },
                owners = ad.owners?.toUByte(),
                priceAmount = ad.price.amount?.toUInt(),
                priceCurrency = ad.price.currency?.toString(),
                vin = ad.vin,
                licensePlate = ad.licensePlate,
                colour = ad.colour?.rgb?.toUInt(),
                makeId = ad.make.id,
                modelId = ad.model.id,
                generationId = ad.generation.id,
                equipment = ad.equipment.id,
                needsRepair = ad.needsRepair,
                pictureIds = ad.pictures?.map { it.id }
                        ?.filter { it != null }?.requireNoNulls(),
                description = ad.description,
                userId = ad.user.id,
                date = ad.date.toString(),
                isActive = ad.isActive
        )
    }

    fun model(): Ad = Ad(
            id = this.id,
            year = this.year?.let { Year.of(it.toInt()) },
            mileage = Mileage(
                    value = this.mileageValue?.toInt(),
                    unit = this.mileageUnit?.let {
                        when (it.toInt()) {
                            1 -> Mileage.MileageUnit.KM
                            2 -> Mileage.MileageUnit.MI
                            else -> Mileage.MileageUnit.DEFAULT
                        }
                    }
            ),
            owners = this.owners?.toInt(),

    )
}