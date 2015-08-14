package com.laprasdrum.sparrow.inject

import com.laprasdrum.sparrow.model.PayrollEdit
import com.laprasdrum.sparrow.model.User
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
public open class ApplicationModule {
    @Provides @Singleton fun provideUser(): User {
        return User(PayrollEdit())
    }
}
