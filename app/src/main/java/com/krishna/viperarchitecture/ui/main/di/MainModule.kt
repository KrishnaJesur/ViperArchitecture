package com.krishna.viperarchitecture.ui.main.di

import com.krishna.viperarchitecture.app.di.ActivityScope
import com.krishna.viperarchitecture.ui.main.*
import com.krishna.viperarchitecture.ui.main.api.MainApi
import com.krishna.viperarchitecture.ui.main.data.MainRepo
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MainModule {

    @Provides
    @ActivityScope
    fun api(retrofit: Retrofit) = retrofit.create(MainApi::class.java)

    @Provides
    @ActivityScope
    fun repository(api: MainApi) = MainRepo(api)

    @Provides
    @ActivityScope
    fun router(activity: MainActivity): MainContract.Router = MainRouter(activity)

    @Provides
    @ActivityScope
    fun presenter(router: MainContract.Router, interactor: MainInteractor) =
        MainPresenter(router, interactor)

    @Provides
    @ActivityScope
    fun interactor(repo: MainRepo) = MainInteractor(repo)

}