package ru.otus.otuskotlin.ads_vehicles.transport.multiplatform.backend

import ru.otus.otuskotlin.ads_vehicles.backend.AdContext
import ru.otus.otuskotlin.ads_vehicles.backend.models.*
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

fun Chassis.Companion.fromReq(reqChassis: String): Chassis =
    when (reqChassis) {
        "coupe" -> Chassis.COUPE
        "sedan" -> Chassis.SEDAN
        "convertible" -> Chassis.CONVERTIBLE
        "liftback" -> Chassis.LIFTBACK
        "hatchback" -> Chassis.HATCHBACK
        "roadster" -> Chassis.ROADSTER
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

fun Drive.Companion.fromReq(reqDrive: String): Drive = 
    when (reqDrive) {
        "rwd" -> Drive.RWD
        "fwd" -> Drive.FWD
        "full_time_awd" -> Drive.FULL_TIME_AWD
        "part_time_awd" -> Drive.PART_TIME_AWD
        else -> throw Exception("Unknown drive type")
    }

fun Engine.Companion.fromReq(reqEngine: String): Engine = 
    when (reqEngine) {
        "petrol" -> Engine.PETROL
        "diesel" -> Engine.DIESEL
        "petrol_boosted" -> Engine.PETROL_BOOSTED
        "diesel_boosted" -> Engine.DIESEL_BOOSTED
        "electric" -> Engine.ELECTRIC
        else -> throw Exception("Unknown engine type")
    }

fun Gearbox.Companion.fromReq(reqGearbox: String): Gearbox = 
    when (reqGearbox) {
        "manual" -> Gearbox.MANUAL
        "auto" -> Gearbox.AUTO
        "robot" -> Gearbox.ROBOT
        "dct" -> Gearbox.DCT
        "cvt" -> Gearbox.CVT
        "none" -> Gearbox.NONE
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
    engine = Engine.fromReq(this.engine!!),
    engineCC = this.engineCC!!,
    powerHP = this.powerHP!!,
    powerKW = this.powerHP!!,
    torqueNM = this.torqueNM!!,
    gearbox = Gearbox.fromReq(this.gearbox!!),
    drive = Drive.fromReq(this.drive!!),
    steeringWheel = SteeringWheel.fromReq(this.steeringWheel!!),
    chassis = Chassis.fromReq(this.chassis!!),
    doors = this.doors!!,
    colour = Colour.fromReq(this.colour!!),
    owners = this.owners!!,
    vin = this.vin!!,
    licensePlate = this.licensePlate!!,
    price = this.price!!,
    user = userById(this.userId!!)
)

fun Ad.kmp(): KmpAd = KmpAd(
    id = this.id,
    year = this.year.value,
    make = this.model.make.name,
    model = this.model.name,
    mileage = this.mileage,
    engine = Engine.displayName(this.engine),
    engineCC = engineCC,
    powerHP = this.powerHP,
    powerKW = this.powerKW,
    torqueNM = this.torqueNM,
    gearbox = Gearbox.displayName(this.gearbox),
    drive = Drive.displayName(this.drive),
    steeringWheel = SteeringWheel.displayName(this.steeringWheel),
    chassis = Chassis.displayName(this.chassis),
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
    User(userId, "", "", null, LocalDate.now(), "", LocalDate.now(), UserStatus.ACTIVE)