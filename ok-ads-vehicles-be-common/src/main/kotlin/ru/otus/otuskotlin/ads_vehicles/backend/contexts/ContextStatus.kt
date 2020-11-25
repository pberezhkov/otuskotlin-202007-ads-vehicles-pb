package ru.otus.otuskotlin.ads_vehicles.backend.contexts

enum class ContextStatus {
    NONE,
    PENDING,
    SUCCESS,
    FAILURE;

    val isError: Boolean
        get() = this.equals(FAILURE)
}