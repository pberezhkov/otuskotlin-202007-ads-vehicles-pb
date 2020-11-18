package ru.otus.otuskotlin.ads_vehicles.backend.models

/**
 * Money amount
 */
data class MoneyAmount(
        val amount: Int? = null,
        val currency: java.util.Currency? = null
) {
    companion object {
        val NONE: MoneyAmount = MoneyAmount()
    }
}