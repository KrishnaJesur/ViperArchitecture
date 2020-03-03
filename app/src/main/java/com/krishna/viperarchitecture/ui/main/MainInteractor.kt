package com.krishna.viperarchitecture.ui.main

import com.krishna.viperarchitecture.app.model.Joke
import com.krishna.viperarchitecture.ui.main.data.MainRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainInteractor(private val repo: MainRepo) : MainContract.Interactor {

    private val compositeDisposable = CompositeDisposable()

    override fun getJokes(onSuccess: (List<Joke>) -> Unit, onError: (Throwable) -> Unit) {
        val disposable = repo.getJokes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError(onError)
            .doOnSuccess(onSuccess)
            .subscribe()

        compositeDisposable.add(disposable)

    }

    fun dispose() = compositeDisposable.dispose()


}