package ru.otus.otuskotlin.ads_vehicles.common.cor

import kotlin.test.Test

class CorTest {
    @Test
    fun testChain(): Unit {
        val chain: IExec<TestContext> = corProcessor {

        }
    }

    data class TestContext(
            val foo: String = "bar"
    )
}