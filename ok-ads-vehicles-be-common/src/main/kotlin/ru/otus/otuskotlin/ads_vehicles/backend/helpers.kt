package ru.otus.otuskotlin.ads_vehicles.backend

import java.security.MessageDigest

fun sha1(input: String): String {
    return MessageDigest.getInstance("SHA-1")
            .digest(input.toByteArray())
            .joinToString(separator = "") { "%02x".format(it) }
}