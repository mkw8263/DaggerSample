package dagger.dagger2.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.dagger2.App

@Module
class AppModule {

    @Provides
    fun provideContext(application: App): Context {
        return application.applicationContext
    }
}
