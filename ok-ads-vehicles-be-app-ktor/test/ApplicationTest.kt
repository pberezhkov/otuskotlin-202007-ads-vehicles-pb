package ru.otus.otuskotlin.ads_vehicles

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.content.*
import io.ktor.http.content.*
import io.ktor.features.*
import kotlin.test.*
import io.ktor.server.testing.*
import kotlinx.serialization.json.Json
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpAdGet
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpAdSingleResponse

class ApplicationTest {
    @Test
    fun testGetAd() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Post, "/api/ad/get") {
                val body = KmpAdGet(
                        adId = "some-id"
                )
                val bodyString = Json.encodeToString(KmpAdGet.serializer(), body)
                setBody(bodyString)
                addHeader("Content-Type", "application/json")
            }
                    .apply {
                        assertEquals(HttpStatusCode.OK, response.status())
                        assertEquals(ContentType.Application.Json.withCharset(Charsets.UTF_8), response.contentType())
                        val jsonString = response.content ?: fail("Null response json")
                        val res = Json.decodeFromString(KmpAdSingleResponse.serializer(), jsonString)
                        assertEquals("some-id", res.data?.id)
                    }
        }
    }
}
