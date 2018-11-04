package dagger.dagger2.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.dagger2.di.ActivityScoped
import dagger.dagger2.ui.MainActivity

@Module
internal abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [ViewModelBindModule::class])
    internal abstract fun mainActivity(): MainActivity
}