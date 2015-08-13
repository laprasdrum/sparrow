package com.laprasdrum.sparrow.model

import android.app.Application
import android.content.Context
import android.test.InstrumentationTestCase

object TestApplication : InstrumentationTestCase() {
    var context: Context? = null;

    override fun setUp() {
        super.setUp()
        context = getInstrumentation().getContext()
    }

    fun getApplication(): Application {
        return context as Application
    }
}
