package dagger.dagger2.ui

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import dagger.dagger2.R
import dagger.dagger2.viewmodel.MainViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val mainViewModel: MainViewModel by lazy {
        ViewModelProviders.of(this, factory)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
