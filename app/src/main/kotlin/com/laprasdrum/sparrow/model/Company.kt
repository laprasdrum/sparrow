package com.laprasdrum.sparrow.model

import javax.inject.Inject

data class Company {
    var user: Employee? = null
        @Inject set

    init {
        //        Injector.get().inject(this)
    }

    public fun checkUser(): String {
        return user?.register("key") ?: "no user"
    }
}

