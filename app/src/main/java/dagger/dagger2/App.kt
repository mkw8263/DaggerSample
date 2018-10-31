package dagger.dagger2

import android.app.Application
import dagger.dagger2.di.AppComponent

class App : Application() {
    lateinit var daggerAppComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        daggerAppComponent = DaggerAppComponent.builder().build()
    }
}