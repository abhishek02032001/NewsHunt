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
import com.example.newshunt.services.ApiService
import kotlinx.android.synthetic.main.fragment_science.*
import kotlinx.android.synthetic.main.fragment_science.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Science : Fragment() {
    private lateinit var adapter : NewsFeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_science, container, false)

        view.newsFeed.layoutManager = LinearLayoutManager(activity)
        adapter = NewsFeedAdapter()
        view.newsFeed.adapter = adapter

        getScienceNews()

        return view
    }

    private fun getScienceNews() {
        val apiHelper : Call<NewsModel> = ApiHelper.apiService.scienceNews()
        apiHelper.enqueue(object : Callback<NewsModel>{
            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                val scienceFeed : ArrayList<ArticleModel>? = response.body()?.articles

                if (scienceFeed != null && scienceFeed.size != 0) {
                    adapter.setNewsfeed(scienceFeed)
                }
            }

            override fun onFailure(call: Call<NewsModel>, t: Throwable) {
                Log.i("Sci", "Sorry")
            }

        })
    }
}