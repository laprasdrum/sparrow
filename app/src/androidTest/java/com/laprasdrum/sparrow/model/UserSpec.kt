package com.laprasdrum.sparrow.model

import org.jetbrains.spek.api.Spek
import kotlin.test.assertEquals

class UserSpec : Spek() {
    init {
        given("user message with payroll edit") {
            val user: User = User(CompanyAdmin())
            on("put short message") {
                val actual = user.register("val")
                it("should be same with register") {
                    assertEquals("registered with admin", actual)
                }
            }
        }
    }
}

