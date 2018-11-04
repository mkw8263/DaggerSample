package dagger.dagger2.di.module

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.dagger2.di.ActivityScoped
import dagger.dagger2.di.ViewModelKey
import dagger.dagger2.viewmodel.MainViewModel
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelBindModule {

    @ActivityScoped
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}