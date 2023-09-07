package com.example.task_15_hometask_internet

//class WeatherResponce(
//    val data: Weather)

data class WeatherResponce(
    val city:String,
    val temperature:String,
    val wind:String,
    val description:String
    //val forecast:DayWeather
)

data class DayWeather(
    val day:String,
    val temperature:String,
    val wind:String
)