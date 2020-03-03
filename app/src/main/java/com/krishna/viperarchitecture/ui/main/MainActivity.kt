package com.krishna.viperarchitecture.ui.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.krishna.viperarchitecture.R
import com.krishna.viperarchitecture.app.App
import com.krishna.viperarchitecture.app.model.Joke
import com.krishna.viperarchitecture.ui.main.adapter.MainAdapter
import com.krishna.viperarchitecture.ui.main.di.DaggerMainComponent
import com.krishna.viperarchitecture.ui.main.di.MainComponent
import com.krishna.viperarchitecture.ui.main.di.MainModule
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    @Inject
    lateinit var presenter: MainPresenter

    val component: MainComponent by lazy {
        DaggerMainComponent.builder()
            .appComponent((application as App).component)
            .activity(this)
            .plus(MainModule())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        component.inject(this)
        presenter.bindView(this)
        presenter.onViewCreated()

    }

    override fun showLoading() {
        recyclerView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        recyclerView.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }

    override fun publishData(data: List<Joke>) {
        val adapter = MainAdapter(data, object : MainAdapter.JokeListener {
            override fun onItemClick(joke: Joke) {
                presenter.onItemClicked(joke)
            }
        })
        recyclerView.adapter = adapter
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun initView() {
        val manager = LinearLayoutManager(this).apply { orientation = LinearLayoutManager.VERTICAL }
        recyclerView.layoutManager = manager
        toolbar.title = "Jokes"
        toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white))
        toolbar.setNavigationOnClickListener { presenter.onBackClicked() }
    }


}
