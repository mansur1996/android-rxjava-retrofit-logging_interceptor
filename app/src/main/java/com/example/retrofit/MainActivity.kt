package com.example.retrofit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofit.adapter.MovieAdapter
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.model.Movie
import com.example.retrofit.retrofit.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var list: ArrayList<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList()
        movieAdapter = MovieAdapter(list)
        initViews()
    }

    @SuppressLint("CheckResult", "NotifyDataSetChanged")
    private fun initViews() {

        RetrofitClient.movieService.getMovie()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result->
                list.addAll(result)
                movieAdapter.notifyDataSetChanged()
            },{ error->
                error.printStackTrace()
            })

        binding.rv.adapter = movieAdapter
    }


}