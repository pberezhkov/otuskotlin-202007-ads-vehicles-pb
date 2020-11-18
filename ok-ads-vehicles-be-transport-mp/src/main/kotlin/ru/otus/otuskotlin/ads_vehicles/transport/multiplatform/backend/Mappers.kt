package ru.otus.otuskotlin.ads_vehicles.transport.multiplatform.backend

import ru.otus.otuskotlin.ads_vehicles.backend.AdContext
import ru.otus.otuskotlin.ads_vehicles.backend.models.*
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Make
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Model
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.enums.*
import ru.otus.otuskotlin.ads_vehicles.transport.models.*
import java.time.LocalDate
import java.time.Year

fun AdContext.setQuery(request: KmpAdGet): AdContext = this.apply {
    this.requestAdId = request.adId
}

fun AdContext.setQuery(request: KmpAdDelete): AdContext = this.apply {
    this.requestAdId = request.adId
}

fun AdContext.setQuery(request: KmpAdCreate): AdContext = this.apply {
    this.requestAd = request.model()
}

fun AdContext.setQuery(request: KmpAdUpdate): AdContext = this.apply {
    this.requestAd = request.model()
}

fun AdContext.singleResult(): KmpAdSingleResponse = KmpAdSingleResponse(
        data = this.responseAd?.kmp(),
        errors = null,
        status = KmpAdResponseStatus.OK
)

fun AdContext.listResult(): KmpAdListResponse = KmpAdListResponse(
        data = this.responseAd?.let { listOf(it.kmp()) },
        errors = null,
        status = KmpAdResponseStatus.OK
)

fun ChassisType.Companion.fromReq(reqChassis: String): ChassisType =
    when (reqChassis) {
        "coupe" -> ChassisType.COUPE
        "sedan" -> ChassisType.SEDAN
        "convertible" -> ChassisType.CONVERTIBLE
        "liftback" -> ChassisType.LIFTBACK
        "hatchback" -> ChassisType.HATCHBACK
        "roadster" -> ChassisType.ROADSTER
        else -> throw Exception("Unknown chassis type")
    }

fun Colour.Companion.fromReq(reqColor: String): Colour =
    when (reqColor) {
        "black" -> Colour.BLACK
        "white" -> Colour.WHITE
        "gray" -> Colour.GRAY
        "red" -> Colour.RED
        "blue" -> Colour.BLUE
        "green" -> Colour.GREEN
        "yellow" -> Colour.YELLOW
        "orange" -> Colour.ORANGE
        "purple" -> Colour.PURPLE
        else -> throw Exception("Unknown colour")
    }

fun DriveType.Companion.fromReq(reqDrive: String): DriveType =
    when (reqDrive) {
        "rwd" -> DriveType.RWD
        "fwd" -> DriveType.FWD
        "full_time_awd" -> DriveType.FULL_TIME_AWD
        "part_time_awd" -> DriveType.PART_TIME_AWD
        else -> throw Exception("Unknown drive type")
    }

fun EngineType.Companion.fromReq(reqEngine: String): EngineType =
    when (reqEngine) {
        "petrol" -> EngineType.PETROL
        "diesel" -> EngineType.DIESEL
        "petrol_boosted" -> EngineType.PETROL_BOOSTED
        "diesel_boosted" -> EngineType.DIESEL_BOOSTED
        "electric" -> EngineType.ELECTRIC
        else -> throw Exception("Unknown engine type")
    }

fun GearboxType.Companion.fromReq(reqGearbox: String): GearboxType =
    when (reqGearbox) {
        "manual" -> GearboxType.MANUAL
        "auto" -> GearboxType.AUTO
        "robot" -> GearboxType.ROBOT
        "dct" -> GearboxType.DCT
        "cvt" -> GearboxType.CVT
        "none" -> GearboxType.NONE
        else -> throw Exception("Unknown gearbox type")
    }

fun SteeringWheel.Companion.fromReq(reqSteeringWheel: String): SteeringWheel =
    when (reqSteeringWheel) {
        "left" -> SteeringWheel.LEFT
        "right" -> SteeringWheel.RIGHT
        else -> throw Exception("Unknown steering wheel")
    }

fun KmpAdSave.model(): Ad = Ad(
    id = if (this is KmpAdUpdate) (this.id ?: "") else "",
    year = Year.of(this.year!!),
    model = modelById(this.modelId!!),
    mileage = this.mileage!!,
    engine = EngineType.fromReq(this.engine!!),
    engineCC = this.engineCC!!,
    powerHP = this.powerHP!!,
    powerKW = this.powerHP!!,
    torqueNM = this.torqueNM!!,
    gearbox = GearboxType.fromReq(this.gearbox!!),
    drive = DriveType.fromReq(this.drive!!),
    steeringWheel = SteeringWheel.fromReq(this.steeringWheel!!),
    chassis = ChassisType.fromReq(this.chassis!!),
    doors = this.doors!!,
    colour = Colour.fromReq(this.colour!!),
    owners = this.owners!!,
    vin = this.vin!!,
    licensePlate = this.licensePlate!!,
    price = this.price!!,
    user = userById(this.userId!!),
    pictures = null
)

fun Ad.kmp(): KmpAd = KmpAd(
    id = this.id,
    year = this.year.value,
    make = this.model.make.name,
    model = this.model.name,
    mileage = this.mileage,
    engine = EngineType.displayName(this.engine),
    engineCC = engineCC,
    powerHP = this.powerHP,
    powerKW = this.powerKW,
    torqueNM = this.torqueNM,
    gearbox = GearboxType.displayName(this.gearbox),
    drive = DriveType.displayName(this.drive),
    steeringWheel = SteeringWheel.displayName(this.steeringWheel),
    chassis = ChassisType.displayName(this.chassis),
    doors = this.doors,
    colour = Colour.displayName(this.colour),
    owners = this.owners,
    vin = this.vin,
    licensePlate = this.licensePlate,
    price = this.price,
    userId = this.user.id
)

// stubs!
private fun modelById(modelId: String): Model =
    Model(modelId, Make("", "", ""), "")

private fun userById(userId: String): User =
    User(userId, "", "", null, LocalDate.now(), "", LocalDate.now(), true)