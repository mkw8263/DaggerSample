package dagger.dagger2.di.module

import dagger.Module
import dagger.Provides
import dagger.dagger2.data.LocalDataSource
import dagger.dagger2.repo.MainRepository

@Module
class RepositoryModule {

    @Provides
    fun getLocalDataSource() = LocalDataSource()

    @Provides
    fun getMainRepo(localDataSource: LocalDataSource): MainRepository = MainRepository(localDataSource)
}