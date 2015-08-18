package com.laprasdrum.sparrow.flux.actions

import android.util.Log
import com.laprasdrum.sparrow.flux.Dispatcher
import com.laprasdrum.sparrow.flux.stores.SampleStore
import com.laprasdrum.sparrow.inject.Injector
import javax.inject.Inject

class SampleActions {
    var sampleStore: SampleStore? = null
        @Inject set

    init {
        Injector.get().inject(this)
    }

    fun initialize() {
        Dispatcher.addAction {
            sampleStore?.onInitialized()
        }
    }

    fun editCompanyName(name: String?) {
        Dispatcher.addAction {
            // do some here (network, or any other task)
            for (i in 1..10) {
                Log.i("TAG", "test on " + i)
            }

            // post event
            sampleStore?.onNameEdited(name)
        }
    }

    fun editCompanyProfile(name: String?, email: String?) {
        Dispatcher.addAction {
            sampleStore?.onProfileEdited(name, email)
        }
    }
}

