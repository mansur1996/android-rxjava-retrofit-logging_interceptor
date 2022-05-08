package com.example.retrofit.retrofit

import com.example.retrofit.model.Movie
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("marvel")
    fun getMovie() : Single<List<Movie>>
}