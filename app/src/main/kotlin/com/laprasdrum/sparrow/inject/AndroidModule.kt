package com.laprasdrum.sparrow.inject

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

Module
public class AndroidModule(private var application: Application) {

    Provides Singleton ForApplication fun provideApplication(): Application {
        return application
    }

    Provides Singleton fun provideApplicationContext(): Context {
        return application.getApplicationContext()
    }

    Provides Singleton fun provideDefaultSharedPreferences(): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }
}