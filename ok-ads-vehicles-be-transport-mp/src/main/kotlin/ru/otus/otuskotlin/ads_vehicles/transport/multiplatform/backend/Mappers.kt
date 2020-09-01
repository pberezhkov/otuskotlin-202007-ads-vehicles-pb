package ru.otus.otuskotlin.ads_vehicles.transport.multiplatform.backend

import ru.otus.otuskotlin.ads_vehicles.backend.models.*
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpAd

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
