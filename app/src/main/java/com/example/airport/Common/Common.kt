package com.example.airport.Common

import com.example.airport.Interface.RetrofitServices
import com.example.airport.Retrofit.RetrofitClient

object Common {
    //ссылка без последней ветки?
    private val BASE_URL = "https://api.rasp.yandex.net/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}

