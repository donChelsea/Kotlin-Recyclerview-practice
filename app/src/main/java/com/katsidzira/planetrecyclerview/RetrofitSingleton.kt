package com.katsidzira.planetrecyclerview

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitSingleton {

    private val BASE_URL = "https://raw.githubusercontent.com/"
    private val zodiacApi: ZodiacApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        zodiacApi = retrofit.create(ZodiacApi::class.java)
    }

    fun getZodiac(): Call<ZodiacList> {
            return zodiacApi.getAll()
    }

}