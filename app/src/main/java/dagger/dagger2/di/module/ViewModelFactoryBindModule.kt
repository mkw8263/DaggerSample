package dagger.dagger2.di.module

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.dagger2.di.ViewModelFactory
import dagger.dagger2.di.component.AppComponent
import dagger.dagger2.viewmodel.MainViewModel

@Module
internal abstract class ViewModelFactoryBindModule {

    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}