package com.laprasdrum.sparrow.flux

import com.laprasdrum.sparrow.inject.Injector
import java.util.concurrent.ExecutorService
import javax.inject.Inject

object Dispatcher {
    var executorService: ExecutorService? = null
        @Inject set

    init {
        Injector.get().inject(this)
    }

    fun addAction(task: () -> Unit) {
        val action = Action(task)
        executorService?.submit(action)
    }
}

