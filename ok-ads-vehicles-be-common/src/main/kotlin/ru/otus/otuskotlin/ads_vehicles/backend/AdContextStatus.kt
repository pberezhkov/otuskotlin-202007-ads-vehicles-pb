package ru.otus.otuskotlin.ads_vehicles.backend

enum class AdContextStatus {
    NONE,
    PENDING,
    SUCCESS,
    FAILURE;

    val isError
        get() = this.equals(FAILURE)
}