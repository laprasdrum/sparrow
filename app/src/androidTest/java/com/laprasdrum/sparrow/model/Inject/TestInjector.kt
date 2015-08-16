package com.laprasdrum.sparrow.model.Inject

import android.app.Application
import android.app.Instrumentation
import android.support.test.InstrumentationRegistry
import com.laprasdrum.sparrow.inject.Injector

object TestInjector {
    fun init() {
        val instrumentation: Instrumentation = InstrumentationRegistry.getInstrumentation()
        val app: Application = instrumentation.getTargetContext().getApplicationContext() as Application
        Injector.init(app)
    }
}