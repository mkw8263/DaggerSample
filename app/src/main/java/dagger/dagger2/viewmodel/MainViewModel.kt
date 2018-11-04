package dagger.dagger2.viewmodel

import android.arch.lifecycle.ViewModel
import dagger.dagger2.repo.MainRepository
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    sealed class User {
        data class Username(val name: String) : User()
    }

    private val userSubject: PublishSubject<User> = PublishSubject.create()
    val userOB: Observable<User>
    val compositeDisposable = CompositeDisposable()

    init {
        userOB = userSubject
    }

    fun getUser(name: String) {
        userSubject.onNext(User.Username(mainRepository.getName(name)))
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}