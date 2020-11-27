package ru.otus.otuskotlin.ads_vehicles.backend.dsl

import ru.otus.otuskotlin.ads_vehicles.backend.dsl.equipment.equipment
import ru.otus.otuskotlin.ads_vehicles.backend.dsl.make.make
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Make
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.enums.EngineType
import kotlin.test.Test
import kotlin.test.assertEquals

class MakeDslTest {
    @Test
    public fun testMakeDsl(): Unit {
        val make: Make = make {
            id { "testid" }
            name { "Skoda" }
            isoCountryCode { "CZ" }
        }

        assertEquals("testid", make.id)
        assertEquals("Skoda", make.name)
        assertEquals("CZ", make.isoCountryCode)
    }
}