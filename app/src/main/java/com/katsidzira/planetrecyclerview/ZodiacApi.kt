package com.katsidzira.planetrecyclerview

import retrofit2.Call
import retrofit2.http.GET

interface ZodiacApi {
    @GET("JDVila/storybook/master/zodiac.json")
    fun getAll(): Call<ZodiacList>
}