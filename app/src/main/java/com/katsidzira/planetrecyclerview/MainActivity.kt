package com.katsidzira.planetrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {
    private val TAG = "Main activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val retrofitSingleton: Disposable = RetrofitSingleton().getInstance()!!
            .create(ZodiacService::class.java)
            .getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ zodiacList ->
                val zodiacs: List<Zodiac> = zodiacList.zodiacList
                recyclerView.adapter = ZodiacAdapter(zodiacList = zodiacs)
                recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
            }, { t ->
                Log.d(TAG, "on failure: ${t.message}")
            })
    }


}