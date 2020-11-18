package ru.otus.otuskotlin.ads_vehicles.transport.multiplatform.backend

import ru.otus.otuskotlin.ads_vehicles.backend.AdContext
import ru.otus.otuskotlin.ads_vehicles.backend.models.*
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Make
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Model
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.enums.*
import ru.otus.otuskotlin.ads_vehicles.transport.models.*
import java.time.LocalDate
import java.time.Year
import java.util.*

class KmpAdService {
    public suspend fun get(query: KmpAdGet): KmpAdSingleResponse = AdContext().run {
        this.setQuery(query)
        this.responseAd = stubModel(query.adId ?: throw RuntimeException("Ad ID missing"))

        return this.singleResult()
    }

    public suspend fun list(): KmpAdListResponse = AdContext().run {
        this.responseAd = stubModel(UUID.randomUUID().toString())

        return this.listResult()
    }

    public suspend fun create(query: KmpAdCreate): KmpAdSingleResponse = AdContext().run {
        this.setQuery(query)
        this.responseAd = stubModel(UUID.randomUUID().toString())

        return this.singleResult()
    }

    public suspend fun update(query: KmpAdUpdate): KmpAdSingleResponse = AdContext().run {
        this.setQuery(query)
        this.responseAd = stubModel(query.id ?: throw RuntimeException("Ad ID missing"))

        return this.singleResult()
    }

    public suspend fun delete(query: KmpAdDelete): KmpAdSingleResponse = AdContext().run {
        this.setQuery(query)
        this.responseAd = stubModel(query.adId ?: throw RuntimeException("Ad ID missing"))

        return this.singleResult()
    }

    private fun stubModel(adId: String): Ad = Ad(
            id = adId,
            year = Year.of(2014),
            model = Model(
                    id = UUID.randomUUID().toString(),
                    make = Make(
                            id = UUID.randomUUID().toString(),
                            name = "Audi",
                            country = "Germany"
                    ),
                    name = "R8"
            ),
            mileage = 2072,
            engine = EngineType.PETROL,
            engineCC = 5204,
            powerHP = 550,
            powerKW = 404,
            torqueNM = 540,
            gearbox = GearboxType.DCT,
            drive = DriveType.FULL_TIME_AWD,
            steeringWheel = SteeringWheel.LEFT,
            chassis = ChassisType.COUPE,
            doors = 2,
            colour = Colour.BLACK,
            owners = 1,
            vin = "WUAKBAFX2L7900832",
            price = 6_099_000_00,
            licensePlate = "P040YH799",
            user = User(
                    id = UUID.randomUUID().toString(),
                    surname = "Pupkin",
                    name = "Vasily",
                    patronymic = "Gennadievich",
                    birthDate = LocalDate.of(1980, 1, 1),
                    phone = "79001234567",
                    registrationDate = LocalDate.of(2020, 9, 15),
                    isActive = true
            )
    )
}