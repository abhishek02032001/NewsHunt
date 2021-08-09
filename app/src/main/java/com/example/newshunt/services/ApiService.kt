package com.example.newshunt.services

import com.example.newshunt.models.NewsModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("top-headlines?country=us&category=business&apiKey=0f5dd3af4a6145909f231e19ad32fdf0")
    fun businessData() : Call<NewsModel>

    @GET("everything?q=education&sortBy=publishedAt&apiKey=0f5dd3af4a6145909f231e19ad32fdf0")
    fun educationNews() : Call<NewsModel>

    @GET("top-headlines?country=us&category=science&apiKey=0f5dd3af4a6145909f231e19ad32fdf0")
    fun scienceNews() : Call<NewsModel>

    @GET("top-headlines?country=us&category=sports&apiKey=0f5dd3af4a6145909f231e19ad32fdf0")
    fun sportsNews() : Call<NewsModel>

    @GET("top-headlines?country=us&category=technology&apiKey=0f5dd3af4a6145909f231e19ad32fdf0")
    fun technology() : Call<NewsModel>

}

object ApiHelper {
    val apiService : ApiService
    init {
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService :: class.java)
    }
}