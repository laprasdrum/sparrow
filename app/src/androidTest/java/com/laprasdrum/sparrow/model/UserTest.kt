package com.laprasdrum.sparrow

import android.support.test.runner.AndroidJUnit4
import com.laprasdrum.sparrow.model.PayrollEdit
import com.laprasdrum.sparrow.model.User
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals

RunWith(AndroidJUnit4::class)
public class UserTest {
    Before
    public fun setup() {
    }

    After
    public fun teardown() {

    }

    Test
    public fun shouldBeCallRegistration() {
        var user: User = User(PayrollEdit())
        assert(user == null, "should be same message")
        assertEquals(1, 2, "test")
    }
}

