package com.example.task_15_hometask_internet

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/weather/{city}")
    fun getWeather(@Path("city") city:String): Call<WeatherResponce>
}

//interface ApiInterface {
//    @GET("/weather/Kyiv")
//    fun getWeather(): Call<WeatherResponce>
//}

//@GET("/weather/{city}")
//fun getWeatherByCity(): Single<WeatherResponce>