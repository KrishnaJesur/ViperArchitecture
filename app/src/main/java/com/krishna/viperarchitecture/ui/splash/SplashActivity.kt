package com.krishna.viperarchitecture.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.krishna.viperarchitecture.R
import com.krishna.viperarchitecture.app.App
import com.krishna.viperarchitecture.ui.splash.di.SplashComponent
import com.krishna.viperarchitecture.ui.splash.di.SplashModule
import  com.krishna.viperarchitecture.ui.splash.di.DaggerSplashComponent
import javax.inject.Inject

class SplashActivity : AppCompatActivity(), SplashContract.View {

    @Inject
    lateinit var presenter: SplashPresenter

    private val component: SplashComponent by lazy {
        DaggerSplashComponent.builder()
            .appComponent((application as App).component)
            .activity(this)
            .plus(SplashModule())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        component.inject(this)
        presenter.bindView(this)
        presenter.onViewCreated()

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }


}