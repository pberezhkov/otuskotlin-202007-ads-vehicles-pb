package ru.otus.otuskotlin.ads_vehicles.backend.models

import java.time.LocalDate

data class User (
        val id: String,
        val firstName: String,
        val lastName: String,
        val middleName: String?,
        val birthDate: LocalDate,
        val phone: String,
        val registrationDate: LocalDate,
        val status: UserStatus
)