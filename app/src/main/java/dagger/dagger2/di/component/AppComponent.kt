package dagger.dagger2.di.component

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.dagger2.App
import dagger.dagger2.di.module.ActivityBindingModule
import dagger.dagger2.di.module.AppModule
import dagger.dagger2.di.module.RepositoryModule
import dagger.dagger2.di.module.ViewModelFactoryBindModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AppModule::class,
        RepositoryModule::class,
        ActivityBindingModule::class,
        ViewModelFactoryBindModule::class]
)

interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Build : AndroidInjector.Builder<App>()
}