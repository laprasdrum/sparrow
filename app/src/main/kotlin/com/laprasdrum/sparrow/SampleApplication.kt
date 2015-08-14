package com.laprasdrum.sparrow

import android.app.Application
import com.laprasdrum.sparrow.inject.Injector

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.init(this)
    }

}
