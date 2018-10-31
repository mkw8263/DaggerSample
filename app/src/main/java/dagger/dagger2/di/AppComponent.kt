package dagger.dagger2.di

import dagger.Component
import dagger.dagger2.ui.MainActivity

@Component(modules = [RepositoryModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}