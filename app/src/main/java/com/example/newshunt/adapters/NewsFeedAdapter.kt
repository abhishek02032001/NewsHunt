package com.example.newshunt.adapters

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newshunt.R
import com.example.newshunt.models.ArticleModel

class NewsFeedAdapter() : RecyclerView.Adapter<NewsViewHolder>(){
    private var newsFeed : ArrayList<ArticleModel> = ArrayList()
    private lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_feed, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentNews : ArticleModel = newsFeed[position]

        if(currentNews.urlToImage != null){
            holder.title.text = currentNews.title
            Glide.with(holder.image.context).load(currentNews.urlToImage).into(holder.image)

            holder.title.setOnClickListener {
                val url = currentNews.url
                val builder = CustomTabsIntent.Builder();
                val customTabsIntent = builder.build();
                customTabsIntent.launchUrl(context, Uri.parse(url));
            }
        }
    }

    override fun getItemCount(): Int {
        return newsFeed.size
    }

    fun setNewsfeed(feed: ArrayList<ArticleModel>) {
        Log.i("Res", "Working")
        newsFeed.clear()
        newsFeed.addAll(feed)

        notifyDataSetChanged()
    }
}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var image : ImageView = itemView.findViewById(R.id.newsImage)
    var title : TextView = itemView.findViewById(R.id.title)
}