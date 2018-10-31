package dagger.dagger2.repo

import dagger.dagger2.data.LocalDataSource
import javax.inject.Inject

class MainRepository @Inject constructor(private val localDataSource: LocalDataSource) {
    fun getName(name: String): String = localDataSource.getName(name)
}