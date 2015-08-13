package com.laprasdrum.sparrow.model

import android.support.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@RunWith(AndroidJUnit4::class)
public class UserTest {
    @Before public fun setup() {
    }

    @After public fun teardown() {

    }

    @Test public fun shouldBeCallRegistration() {
        var user: User = User(PayrollEdit())
        assertEquals(user.register("register"), "registered", "test")
    }

    @Test public fun checkCompanyInjection() {
        var company = Company()
        var user = Mockito.mock(javaClass<PayrollEdit>())
        Mockito.`when`(user.register("register")).thenReturn("registered")
        company.user = user

        assertNotNull(company.user)
        assertEquals(company.checkUser(), "registered", "must load")
    }
}

