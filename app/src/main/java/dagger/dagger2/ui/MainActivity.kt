package dagger.dagger2.ui

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dagger.dagger2.App
import dagger.dagger2.R
import dagger.dagger2.repo.MainRepository
import dagger.dagger2.viewmodel.MainViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var mainRepository: MainRepository

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T = MainViewModel(
                mainRepository
            ) as T
        })[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).daggerAppComponent.inject(this)

        subscribeUI()
        mainViewModel.getUser("홍길동")
    }

    @SuppressLint("CheckResult")
    private fun subscribeUI() {
        mainViewModel.compositeDisposable.add(mainViewModel.userOB
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { user ->
                when (user) {
                    is MainViewModel.User.Username -> textview.text = user.name
                }
            })
    }
}
