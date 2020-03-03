package com.krishna.viperarchitecture.app

import android.app.Application
import com.krishna.viperarchitecture.app.di.AppComponent
import com.krishna.viperarchitecture.app.di.AppModule
import com.krishna.viperarchitecture.app.di.DaggerAppComponent

class App : Application() {

    companion object
    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
            .context(this)
            .plus(AppModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

}