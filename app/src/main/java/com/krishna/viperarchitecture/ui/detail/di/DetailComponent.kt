package com.krishna.viperarchitecture.ui.detail.di

import com.krishna.viperarchitecture.app.di.ActivityScope
import com.krishna.viperarchitecture.app.di.AppComponent
import com.krishna.viperarchitecture.ui.detail.DetailActivity
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [DetailModule::class], dependencies = [AppComponent::class])
interface DetailComponent {

    fun inject(target: DetailActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: DetailActivity): Builder

        fun appComponent(appComponent: AppComponent): Builder

        fun plus(detailModule: DetailModule): Builder

        fun build(): DetailComponent
    }
}