package com.laprasdrum.sparrow.model

import android.support.test.runner.AndroidJUnit4
import com.laprasdrum.sparrow.model.Inject.TestInjector
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@RunWith(AndroidJUnit4::class)
public class CompanyTest {

    @Before public fun setup() {
        TestInjector.init()
    }

    @After public fun teardown() {

    }

    @Test public fun checkCompanyInjection() {
        var company = Company()

        assertNotNull(company.user)
        assertEquals(company.checkUser(), "registered with admin", "must load")
    }
}
