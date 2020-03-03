package com.krishna.viperarchitecture.ui.main.data

import com.krishna.viperarchitecture.app.model.Joke
import com.krishna.viperarchitecture.ui.main.MainContract
import com.krishna.viperarchitecture.ui.main.api.MainApi
import io.reactivex.Single

class MainRepo(private val api: MainApi) : MainContract.Repo {
    override fun getJokes(): Single<List<Joke>> = api.getData()
}