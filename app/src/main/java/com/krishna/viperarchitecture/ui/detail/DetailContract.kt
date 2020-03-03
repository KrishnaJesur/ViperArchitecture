package com.krishna.viperarchitecture.ui.detail

import com.krishna.viperarchitecture.app.model.Joke

interface DetailContract {

    interface View {
        fun PublishData(joke: Joke)

        fun showMessage(msg: Int)

    }

    interface presenter {
        fun bindView(view: View)
        fun unbindView()
        fun onViewCreated(joke: Joke)
        fun onBackClicked()
        fun onEmptyData(msg: Int)
    }

    interface Router {
        fun finish()
    }
}