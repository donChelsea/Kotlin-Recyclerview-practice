package com.katsidzira.planetrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.zodiac_list_view.view.*

class ZodiacAdapter(val zodiacList: List<Zodiac>) : RecyclerView.Adapter<ZodiacAdapter.ZodiacViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
        ZodiacViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.zodiac_list_view, p0, false)
    )

    override fun getItemCount() = zodiacList.size

    override fun onBindViewHolder(p0: ZodiacViewHolder, p1: Int) {
        p0.onBind(zodiacList[p1])
    }

    class ZodiacViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val nameTv = view.name_textview
        private val numberTv = view.number_textview
        private val imageIv = view.imageview

        fun onBind(zodiac: Zodiac) {
            nameTv.text = zodiac.name
            numberTv.text = zodiac.number.toString()
            Picasso.get().load(zodiac.image).into(imageIv)
        }
    }
}