package com.katsidzira.planetrecyclerview

import io.reactivex.Observable
import retrofit2.http.GET

interface ZodiacService {
    @GET("JDVila/storybook/master/zodiac.json")
    fun getAll(): Observable<ZodiacList>
}