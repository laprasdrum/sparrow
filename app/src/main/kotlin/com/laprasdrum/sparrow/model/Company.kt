package com.laprasdrum.sparrow.model

import com.laprasdrum.sparrow.inject.Injector
import javax.inject.Inject

data class Company {
    var user: User? = null
        @Inject set

    init {
        Injector.get().inject(this)
    }

    public fun checkUser(): String {
        return user?.register("key") ?: "no user"
    }
}
