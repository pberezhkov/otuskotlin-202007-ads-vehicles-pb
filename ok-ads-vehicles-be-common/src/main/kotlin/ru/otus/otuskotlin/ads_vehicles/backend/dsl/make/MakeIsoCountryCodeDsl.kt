package ru.otus.otuskotlin.ads_vehicles.backend.dsl.make

@MakeDslMarker
class MakeIsoCountryCodeDsl(
        var isoCountryCode: String = ""
) {
    companion object {
        val EMPTY: MakeIsoCountryCodeDsl = MakeIsoCountryCodeDsl()
    }
}
