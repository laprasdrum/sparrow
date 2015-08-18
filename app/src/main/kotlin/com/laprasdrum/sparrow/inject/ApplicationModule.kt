package com.laprasdrum.sparrow.inject

import com.laprasdrum.sparrow.flux.actions.SampleActions
import com.laprasdrum.sparrow.flux.stores.SampleStore
import com.laprasdrum.sparrow.model.CompanyAdmin
import com.laprasdrum.sparrow.model.User
import com.squareup.okhttp.OkHttpClient
import dagger.Module
import dagger.Provides
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
public open class ApplicationModule {
    @Provides @Singleton fun provideUser(): User {
        return User(CompanyAdmin())
    }

    @Provides @Singleton fun provideExecutorService(): ExecutorService {
        return Executors.newFixedThreadPool(1)
    }

    @Provides @Singleton fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient()
    }

    @Provides @Singleton fun provideSampleActions(): SampleActions {
        return SampleActions()
    }

    @Provides @Singleton fun provideSampleStore(): SampleStore {
        return SampleStore()
    }
}
