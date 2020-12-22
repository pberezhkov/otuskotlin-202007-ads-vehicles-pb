package ru.otus.otuskotlin.ads_vehicles.common.cor

interface IExec<T> {
    suspend fun exec(ctx: T): Unit
}