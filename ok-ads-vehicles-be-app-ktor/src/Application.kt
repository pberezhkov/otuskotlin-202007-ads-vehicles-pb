package ru.otus.otuskotlin.ads_vehicles

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import kotlinx.serialization.json.Json
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpMakeIndexQuery

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

    install(ContentNegotiation) {
        json(
                contentType = ContentType.Application.Json,
                json = Json {
                    prettyPrint = true
                }
        )
    }

    routing {
        route("/api") {
            get("/make/index") {
                call.respond(service.indexMake(call.receive<KmpMakeIndexQuery>()))
            }

            get("/model/index") {

            }

            get("/generation/index") {

            }

            get("/equipment/index") {

            }

            post("/ad") {

            }

            patch("/ad") {

            }

            get("/ad/index") {

            }

            get("/ad") {

            }
        }
    }
}

