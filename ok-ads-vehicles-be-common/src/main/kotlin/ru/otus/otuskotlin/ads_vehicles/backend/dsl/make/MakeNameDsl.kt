package ru.otus.otuskotlin.ads_vehicles.backend.dsl.make

@MakeDslMarker
class MakeNameDsl(
    var name: String = ""
) {
    companion object {
        val EMPTY: MakeNameDsl = MakeNameDsl()
    }
}