package ru.otus.otuskotlin.ads_vehicles.backend.exceptions

class RepositoryIsNotInitialized(classname: String) : RuntimeException("Repository is not initialized: $classname") {
}