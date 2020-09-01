package ru.otus.otuskotlin.ads_vehicles.backend

interface EnumMapper<T> {
    fun displayName(enum: T): String
}