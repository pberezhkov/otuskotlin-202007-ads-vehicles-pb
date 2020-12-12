package ru.otus.otuskotlin.ads_vehicles.backend.datasets

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Equipment

class ToyotaStock(): IVehicleStockDataSet {
    override fun getTree(): Collection<Equipment> {
        return listOf()
    }
}