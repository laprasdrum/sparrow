package com.laprasdrum.sparrow.flux.stores

import android.util.Log
import com.laprasdrum.sparrow.inject.Injector
import com.laprasdrum.sparrow.model.Company
import rx.subjects.PublishSubject

class SampleStore {
    var editedNameSubject: PublishSubject<String> = PublishSubject.create()
    var editedEmailSubject: PublishSubject<String> = PublishSubject.create()
    var editedCompanyProfileSubject: PublishSubject<String> = PublishSubject.create()

    var company: Company? = null

    init {
        Injector.get().inject(this)
    }

    fun onInitialized() {
        company = Company()
    }

    fun onNameEdited(name: String?) {
        company?.name = name ?: "demo company"
        editedNameSubject.onNext(name)
    }

    fun onEmailEdited(email: String?) {
        Log.d("Store", "on email edited")
        company?.email = email ?: ""
        editedEmailSubject.onNext(email)
    }

    fun onProfileEdited(name: String?, email: String?) {
        company?.name = name ?: "demo company"
        company?.email = email ?: ""
        editedCompanyProfileSubject.onNext(null)
    }
}

