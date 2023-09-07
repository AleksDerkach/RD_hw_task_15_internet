package com.example.task_15_hometask_internet

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    val okHttpClient = OkHttpClient.Builder().build()
    val client = Retrofit.Builder()
        .baseUrl("https://goweather.herokuapp.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build()


//    val okHttpClient = OkHttpClient.Builder().build()
//    val client = Retrofit.Builder()
//        .baseUrl("https://goweather.herokuapp.com/")
//        .client(okHttpClient)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()


}