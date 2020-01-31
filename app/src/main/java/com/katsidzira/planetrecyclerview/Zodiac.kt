package com.katsidzira.planetrecyclerview

import com.google.gson.annotations.SerializedName

data class Zodiac(
    val name: String,
    val number: Int,
    val image: String
)

data class ZodiacList(
    @SerializedName("zodiac")
    val zodiacList: List<Zodiac>
)
