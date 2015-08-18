package com.laprasdrum.sparrow.model

import com.laprasdrum.sparrow.inject.Injector
import javax.inject.Inject

class Company {
    var user: User? = null
        @Inject set

    var name: String? = null
    var email: String? = null

    init {
        Injector.get().inject(this)
    }

    public fun checkUser(): String {
        return user?.register("key") ?: "no user"
    }
}
