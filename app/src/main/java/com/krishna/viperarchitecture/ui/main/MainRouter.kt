package com.krishna.viperarchitecture.ui.main

import android.util.Log
import com.krishna.viperarchitecture.app.model.Joke
import com.krishna.viperarchitecture.ui.detail.DetailActivity

class MainRouter(private val activity: MainActivity) : MainContract.Router {
    override fun finish() {
        activity.finish()
    }

    override fun openFullJoke(data: Joke) {
        Log.d("ItemClickedname", data.name)
        DetailActivity.launch(activity, data)
    }
}