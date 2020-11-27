package ru.otus.otuskotlin.ads_vehicles

import kotlinx.coroutines.runBlocking
import ru.otus.otuskotlin.ads_vehicles.backend.dsl.equipment.equipment
import ru.otus.otuskotlin.ads_vehicles.backend.dsl.generation.generation
import ru.otus.otuskotlin.ads_vehicles.backend.dsl.make.make
import ru.otus.otuskotlin.ads_vehicles.backend.dsl.model.model
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Equipment
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Generation
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Make
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Model
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.enums.*
import ru.otus.otuskotlin.ads_vehicles.backend.repositories.IEquipmentRepository
import ru.otus.otuskotlin.ads_vehicles.backend.repositories.IGenerationRepository
import ru.otus.otuskotlin.ads_vehicles.backend.repositories.IMakeRepository
import ru.otus.otuskotlin.ads_vehicles.backend.repositories.IModelRepository

class CatalogSeeder(
        private val makeRepository: IMakeRepository
//        private val modelRepository: IModelRepository,
//        private val generationRepository: IGenerationRepository,
//        private val equipmentRepository: IEquipmentRepository
) {
    public fun seed(): Unit {
        runBlocking {
            this@CatalogSeeder.seedAudi()
            this@CatalogSeeder.seedBmw()
        }
    }

    suspend private fun seedAudi(): Unit {
        val audi: Make = make {
            name { "Audi" }
            isoCountryCode { "DE" }
        }
        this.makeRepository.create(audi)

        val a4: Model = model {
            make { audi }
            name { "A4" }
        }
//        this.modelRepository.create(a4)

        val a4b5: Generation = generation {
            model { a4 }
            name { "B5" }
            yearFrom { 1994 }
            yearTo { 2001 }
        }

        val a4b7: Generation = generation {
            model { a4 }
            name { "B7" }
            yearFrom { 2004 }
            yearTo { 2009 }
        }

//        this.generationRepository.create(a4b5)
//        this.generationRepository.create(a4b7)

        val a4b5p16mt: Equipment = equipment {
            generation { a4b5 }
            name { "1.8 MT" }
            engine { EngineType.PETROL }
            engineLayout { EngineLayout.FRONT_STRAIGHT }
            engineCC { 1781 }
            boost { BoostType.NA }
            cylinderLayout { EngineCylinderLayout.INLINE }
            cylinders { 4 }
            power { 125 }
            gearbox { GearboxType.MANUAL }
            gears { 5 }
            drive { DriveType.FULL_TIME_AWD }
            steeringWheel { SteeringWheel.LEFT }
            chassis { ChassisType.SEDAN }
        }

        val a4b7p20mt: Equipment = equipment {
            generation { a4b5 }
            name { "2.0 MT" }
            engine { EngineType.PETROL }
            engineLayout { EngineLayout.FRONT_STRAIGHT }
            engineCC { 1984 }
            boost { BoostType.TURBO }
            cylinderLayout { EngineCylinderLayout.INLINE }
            cylinders { 4 }
            power { 220 }
            gearbox { GearboxType.MANUAL }
            gears { 6 }
            drive { DriveType.FULL_TIME_AWD }
            steeringWheel { SteeringWheel.LEFT }
            chassis { ChassisType.SEDAN }
        }

//        this.equipmentRepository.create(a4b5p16mt)
//        this.equipmentRepository.create(a4b7p20mt)
    }

    suspend private fun seedBmw(): Unit {
        val bmw: Make = make {
            name { "BMW" }
            isoCountryCode { "DE" }
        }

        this.makeRepository.create(bmw)

        val _3er: Model = model {
            make { bmw }
            name { "3" }
        }

//        this.modelRepository.create(_3er)

        val e46: Generation = generation {
            model { _3er }
            name { "e46" }
            yearFrom { 1998 }
            yearTo { 2003 }
        }

        val e92: Generation = generation {
            model { _3er }
            name { "e92" }
            yearFrom { 2005 }
            yearTo { 2010 }
        }

//        this.generationRepository.create(e46)
//        this.generationRepository.create(e92)

        val e46330ci: Equipment = equipment {
            name { "330ci" }
            engine { EngineType.PETROL }
            engineLayout { EngineLayout.FRONT_STRAIGHT }
            engineCC { 2979 }
            boost { BoostType.NA }
            cylinderLayout { EngineCylinderLayout.INLINE }
            cylinders { 6 }
            power { 231 }
            gearbox { GearboxType.AUTO }
            gears { 5 }
            drive { DriveType.RWD }
            steeringWheel { SteeringWheel.LEFT }
            chassis { ChassisType.COUPE }
        }

        val e92335: Equipment = equipment {
            name { "335i" }
            engine { EngineType.PETROL }
            engineLayout { EngineLayout.FRONT_STRAIGHT }
            engineCC { 2979 }
            boost { BoostType.TURBO }
            cylinderLayout { EngineCylinderLayout.INLINE }
            cylinders { 6 }
            power { 306 }
            gearbox { GearboxType.MANUAL }
            gears { 6 }
            drive { DriveType.RWD }
            steeringWheel { SteeringWheel.LEFT }
            chassis { ChassisType.COUPE }
        }

//        this.equipmentRepository.create(e46330ci)
//        this.equipmentRepository.create(e92335)
    }
}