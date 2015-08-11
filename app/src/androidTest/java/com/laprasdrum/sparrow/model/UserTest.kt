package com.laprasdrum.sparrow.model

import android.support.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals

RunWith(AndroidJUnit4::class)
public class UserTest {
    Before public fun setup() {
    }

    After public fun teardown() {

    }

    Test public fun shouldBeCallRegistration() {
        var user: User = User(PayrollEdit())
        assertEquals(user.register("register"), "registered", "test")
    }
}

