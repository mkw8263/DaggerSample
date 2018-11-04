package dagger.dagger2

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.dagger2.di.component.DaggerAppComponent

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}