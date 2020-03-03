package com.krishna.viperarchitecture.ui.detail.di

import com.krishna.viperarchitecture.app.di.ActivityScope
import com.krishna.viperarchitecture.ui.detail.DetailActivity
import com.krishna.viperarchitecture.ui.detail.DetailContract
import com.krishna.viperarchitecture.ui.detail.DetailPresenter
import com.krishna.viperarchitecture.ui.detail.DetailRouter
import dagger.Module
import dagger.Provides

@Module
class DetailModule {

    @Provides
    @ActivityScope
    fun router(activity: DetailActivity): DetailContract.Router = DetailRouter(activity)

    @Provides
    @ActivityScope
    fun presenter(router: DetailContract.Router) = DetailPresenter(router)
}