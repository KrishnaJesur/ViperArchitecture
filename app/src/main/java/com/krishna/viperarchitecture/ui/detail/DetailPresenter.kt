package com.krishna.viperarchitecture.ui.detail

import com.krishna.viperarchitecture.app.model.Joke

class DetailPresenter(private val router: DetailContract.Router) : DetailContract.presenter {

    private var view: DetailContract.View? = null

    override fun bindView(view: DetailContract.View) {
        this.view = view
    }

    override fun unbindView() {
        view = null
    }

    override fun onViewCreated(joke: Joke) {
        view?.PublishData(joke)
    }

    override fun onBackClicked() {
        router.finish()
    }

    override fun onEmptyData(msg: Int) {
        view?.showMessage(msg)
        router.finish()
    }
}