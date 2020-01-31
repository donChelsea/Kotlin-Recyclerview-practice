package com.katsidzira.planetrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG = "Main activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val retrofitSingleton = RetrofitSingleton()
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        var zodiacService: ZodiacService = retrofitSingleton.RetrofitSingleton()!!.create(ZodiacService::class.java)
        zodiacService.getAll().enqueue(object : Callback<ZodiacList> {
            override fun onFailure(call: Call<ZodiacList>, t: Throwable) {
                Log.d(TAG, "on failure", t)
            }

            override fun onResponse(call: Call<ZodiacList>, response: Response<ZodiacList>) {
               val zodiacList: ZodiacList = response.body()!!
               recyclerView.adapter = ZodiacAdapter(zodiacList = zodiacList)
            }

        })


    }


}