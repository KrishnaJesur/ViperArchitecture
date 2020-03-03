package com.krishna.viperarchitecture.ui.main.adapter

import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.krishna.viperarchitecture.R
import com.krishna.viperarchitecture.app.model.Joke
import kotlinx.android.synthetic.main.item_joke.view.*

class MainAdapter(private val jokes: List<Joke>, private val listener: JokeListener): RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    interface JokeListener {
        fun onItemClick(joke: Joke)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_joke, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.name!!
        val desc = itemView.desc!!
        val site = itemView.site!!
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        holder.name.text = jokes[position].desc
        holder.site.text = jokes[position].site
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.desc.text = Html.fromHtml(jokes[position].elementPureHtml, Html.FROM_HTML_MODE_LEGACY)
        } else {
            holder.desc.text = (Html.fromHtml(jokes[position].elementPureHtml))
        }

        holder.itemView.setOnClickListener { listener.onItemClick(jokes[position]) }
    }


}