package com.katsidzira.planetrecyclerview

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class RetrofitSingleton {

    private val BASE_URL = "https://raw.githubusercontent.com/"
    private var retrofit: Retrofit? = null

    fun RetrofitSingleton(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}