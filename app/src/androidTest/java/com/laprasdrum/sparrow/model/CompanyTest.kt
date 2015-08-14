package com.laprasdrum.sparrow.model

import android.app.Application
import android.app.Instrumentation
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.laprasdrum.sparrow.inject.Injector
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@RunWith(AndroidJUnit4::class)
public class CompanyTest {

    @Before public fun setup() {
        val instrumentation: Instrumentation = InstrumentationRegistry.getInstrumentation()
        val app: Application = instrumentation.getTargetContext().getApplicationContext() as Application
        Injector.init(app)
    }

    @After public fun teardown() {

    }

    @Test public fun checkCompanyInjection() {
        var company = Company()
        //        Mockito.`when`(company.user?.register("register")).thenReturn("registeredeee")

        assertNotNull(company.user)
        assertEquals(company.checkUser(), "registered", "must load")
    }
}


