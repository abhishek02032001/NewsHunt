package com.example.newshunt.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newshunt.R
import com.example.newshunt.adapters.NewsFeedAdapter
import com.example.newshunt.models.ArticleModel
import com.example.newshunt.models.NewsModel
import com.example.newshunt.services.ApiHelper
import kotlinx.android.synthetic.main.fragment_science.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Sports : Fragment() {

    private lateinit var adapter: NewsFeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sports, container, false)

        view.newsFeed.layoutManager = LinearLayoutManager(activity)
        adapter = NewsFeedAdapter()
        view.newsFeed.adapter = adapter

        getSportsNews()

        return view
    }

    private fun getSportsNews() {
        var apiHelper: Call<NewsModel> = ApiHelper.apiService.sportsNews()

        apiHelper.enqueue(object : Callback<NewsModel>{
            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                var sportsFeed: ArrayList<ArticleModel>? = response.body()?.articles
                if(sportsFeed != null && sportsFeed.size != 0){
                    adapter.setNewsfeed(sportsFeed)
                    Log.i("Ed", sportsFeed.get(0).toString())
                }
            }

            override fun onFailure(call: Call<NewsModel>, t: Throwable) {
                Log.i("Res", "Sorry")
            }

        })

    }
}