package com.laprasdrum.sparrow.inject

import com.laprasdrum.sparrow.MainActivity
import com.laprasdrum.sparrow.MainFragment
import com.laprasdrum.sparrow.SampleApplication
import com.laprasdrum.sparrow.model.Company
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidModule::class, ApplicationModule::class))
public interface ApplicationComponent {
    public fun inject(application: SampleApplication)
    public fun inject(activity: MainActivity)
    public fun inject(fragment: MainFragment)
    public fun inject(company: Company)
}