package ru.otus.otuskotlin.ads_vehicles.backend.datasets

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Equipment

class FullStock(): IVehicleStockDataSet {
    override fun getTree(): Collection<Equipment> {
        return germany()
                .plus(japan())
                .plus(gb())
                .plus(us())
    }

    private fun germany(): Collection<Equipment> {
        return AudiStock().getTree()
                .plus(BmwStock().getTree())
    }

    private fun japan(): Collection<Equipment> {
        return ToyotaStock().getTree()
    }

    private fun gb(): Collection<Equipment> {
        return listOf()
    }

    private fun us(): Collection<Equipment> {
        return listOf()
    }
}