package com.jose.hackernews.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.jose.hackernews.R
import com.jose.hackernews.data.model.Hits

typealias OnSwipeItem = (Hits) -> Unit
class HackerNewsAdapter(var hackerNews: ArrayList<Hits> ): RecyclerView.Adapter<HackerNewsAdapter.HackerNewsHolder>(){

    var onSwipeItem : OnSwipeItem?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HackerNewsHolder {
        return HackerNewsHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_hacker_new,parent,false))
    }

    override fun getItemCount(): Int {
        return hackerNews.size
    }

    override fun onBindViewHolder(holder: HackerNewsHolder, position: Int) {
        holder.bind(hackerNews[position])
    }

    class HackerNewsHolder(view: View): RecyclerView.ViewHolder(view){
        private val title: MaterialTextView = itemView.findViewById(R.id.textView_title)
        private val author: MaterialTextView = itemView.findViewById(R.id.textView_author)
        private val createAt: MaterialTextView = itemView.findViewById(R.id.create_at)

        fun bind(data: Hits){
            title.text = data.storyTitle ?: ""
            author.text = data.author ?: ""
            createAt.text = data.createdAt ?: ""
        }
    }
}