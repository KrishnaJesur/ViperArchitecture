package com.krishna.viperarchitecture.ui.main.api

import com.krishna.viperarchitecture.app.model.Joke
import io.reactivex.Single
import retrofit2.http.GET

interface MainApi {

    @GET("api/random")
    fun getData(): Single<List<Joke>>
}