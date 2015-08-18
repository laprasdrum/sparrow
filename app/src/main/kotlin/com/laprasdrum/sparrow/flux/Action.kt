package com.laprasdrum.sparrow.flux

open class Action(task: () -> Unit) : Runnable {
    var task = task

    override fun run() {
        task()
    }
}
