package com.krishna.viperarchitecture.ui.splash

import com.krishna.viperarchitecture.ui.main.MainActivity

class SplashRouter(private val activity: SplashActivity) : SplashContract.Router {
    override fun openMain() {
        MainActivity.launch(activity)
        activity.finish()
    }
}