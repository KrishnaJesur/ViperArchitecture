package com.krishna.viperarchitecture.ui.splash.di

import com.krishna.viperarchitecture.app.di.ActivityScope
import com.krishna.viperarchitecture.ui.splash.SplashActivity
import com.krishna.viperarchitecture.ui.splash.SplashContract
import com.krishna.viperarchitecture.ui.splash.SplashPresenter
import com.krishna.viperarchitecture.ui.splash.SplashRouter
import dagger.Module
import dagger.Provides

@Module
class SplashModule {

    @Provides
    @ActivityScope
    fun router(activity: SplashActivity): SplashContract.Router = SplashRouter(activity)

    @Provides
    @ActivityScope
    fun presenter(router: SplashContract.Router) = SplashPresenter(router)
}