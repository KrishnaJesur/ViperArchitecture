package com.krishna.viperarchitecture.ui.splash

import android.os.Handler

class SplashPresenter(private val router: SplashContract.Router) : SplashContract.Presenter {

    companion object {
        private const val SPLASH_TIME_DELAY = 5000L
    }

    private var view: SplashContract.View? = null

    override fun bindView(view: SplashContract.View) {
        this.view = view
    }

    override fun unbindView() {
        view = null
    }

    override fun onViewCreated() {
        Handler().postDelayed({router.openMain()}, SPLASH_TIME_DELAY)
    }
}