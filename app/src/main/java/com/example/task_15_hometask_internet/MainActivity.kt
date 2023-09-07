package com.example.task_15_hometask_internet

import android.app.Activity
import android.content.res.Resources
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity: Activity() {
    private lateinit var tvTempre: TextView
    private lateinit var tvWind: TextView
    private lateinit var tvDescr: TextView
    private lateinit var btnSearch: Button
    private lateinit var etCity: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        tvTempre = findViewById<TextView>(R.id.tvTempre)
        tvWind = findViewById<TextView>(R.id.tvWind)
        tvDescr = findViewById<TextView>(R.id.tvDescr)
        etCity = findViewById<EditText>(R.id.etWeatgerPoint)
        btnSearch = findViewById<Button>(R.id.button)
        btnSearch.setOnClickListener {

            val client = ApiClient.client.create(ApiInterface::class.java)
            client.getWeather(etCity.text.toString()).enqueue(object: Callback<WeatherResponce>{
            override fun onResponse(
                    call: Call<WeatherResponce>,
                    response: Response<WeatherResponce>
                ) {
                    if(response.isSuccessful) {
                        val data = response.body()!!
                        tvTempre.text = "Temp: ${data.temperature}"
                        tvWind.text   = "Wind: ${data.wind}"
                        tvDescr.text  = "Desc: ${data.description}"
                    }
                }
                override fun onFailure(call: Call<WeatherResponce>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Error ", Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}