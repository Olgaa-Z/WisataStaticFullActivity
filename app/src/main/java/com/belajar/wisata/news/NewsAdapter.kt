package com.belajar.wisata.news

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.belajar.wisata.R
import com.bumptech.glide.Glide

class NewsAdapter(private val erwinModel: List<DataItem>,val listener: (DataItem)-> Unit) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    private var ct: Context? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val l = LayoutInflater.from(viewGroup.context)
        val v = l.inflate(R.layout.activity_news_adapter, viewGroup, false)
        ct = viewGroup.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val sp = erwinModel[position]
        viewHolder.tv_judul.text = sp.judul
        viewHolder.tv_isi.text = sp.isiBerita
        viewHolder.tv_tanggal.text = sp.tglBerita
        ct?.let { Glide.with(it).load(ApiClient.BASE_URL+"assets/gambar/${sp.gambar}").into(viewHolder.iv_gambar) }
        viewHolder.linear.setOnClickListener {
            listener(sp)
        }
    }

    override fun getItemCount(): Int {
        return erwinModel.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var tv_judul: TextView = itemView.findViewById(R.id.tv_utama_judul)
        internal var tv_isi: TextView = itemView.findViewById(R.id.tv_utama_isi)
        internal var tv_tanggal: TextView = itemView.findViewById(R.id.tv_utama_tanggal)
        internal var iv_gambar: ImageView =itemView.findViewById(R.id.iv_utama_gambar)
        internal var linear: LinearLayout =itemView.findViewById(R.id.linear_utama)
    }
}