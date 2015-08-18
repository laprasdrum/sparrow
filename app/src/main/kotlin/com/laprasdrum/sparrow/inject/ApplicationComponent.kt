package com.laprasdrum.sparrow.inject

import com.laprasdrum.sparrow.MainActivity
import com.laprasdrum.sparrow.MainFragment
import com.laprasdrum.sparrow.SampleApplication
import com.laprasdrum.sparrow.SampleFragment
import com.laprasdrum.sparrow.WebAction.NetworkDispatcher
import com.laprasdrum.sparrow.flux.Dispatcher
import com.laprasdrum.sparrow.flux.actions.SampleActions
import com.laprasdrum.sparrow.flux.stores.SampleStore
import com.laprasdrum.sparrow.model.Company
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidModule::class, ApplicationModule::class))
public interface ApplicationComponent {
    fun inject(application: SampleApplication)
    fun inject(activity: MainActivity)
    fun inject(fragment: MainFragment)
    fun inject(company: Company)
    fun inject(dispatcher: Dispatcher)
    fun inject(networkDispatcher: NetworkDispatcher)
    fun inject(networkQueueStore: SampleStore)
    fun inject(sampleActions: SampleActions)
    fun inject(fragment: SampleFragment)
}