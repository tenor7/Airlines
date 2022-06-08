package com.example.airport.Interface


import com.example.airport.model.Flights
import retrofit2.Call
import retrofit2.http.Url

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitServices {
    @GET("/{url}")
    fun getMovieList(@Path("url") url:String,
        @Query("apikey") apikey: String,
                     @Query("format") json:String,
                     @Query("from") from:String,
                     @Query("to") to:String,
                     @Query("date")date:String,
                     @Query("transport_type")transportType: String
): Call<Flights>
}
