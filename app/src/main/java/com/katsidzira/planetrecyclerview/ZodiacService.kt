package com.katsidzira.planetrecyclerview

import retrofit2.Call
import retrofit2.http.GET

interface ZodiacService {
    @GET("JDVila/storybook/master/zodiac.json")
    fun getAll(): Call<ZodiacList>
}