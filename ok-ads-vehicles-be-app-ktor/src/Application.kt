package ru.otus.otuskotlin.ads_vehicles

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpAdGet
import ru.otus.otuskotlin.ads_vehicles.transport.multiplatform.backend.KmpAdService

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val service: KmpAdService = KmpAdService()

    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        header(HttpHeaders.Authorization)
        header("MyCustomHeader")
        allowCredentials = true
        anyHost() // @TODO: Don't do this in production if possible. Try to limit it.
    }

    routing {
        route("/api") {
            post("/ad/get") {
                val query = call.receive<KmpAdGet>()
                call.respond(service.get(query))
            }

            post("/ad/list") {

            }

            post("/ad/create") {

            }

            post("/ad/update") {

            }

            post("/ad/delete") {

            }
        }
    }
}

