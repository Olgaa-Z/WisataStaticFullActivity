package com.belajar.wisata.news

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.belajar.wisata.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_news.*
import retrofit2.Call
import retrofit2.Callback
import java.util.ArrayList

class News : AppCompatActivity() {

    private var erwinModel: List<DataItem> = ArrayList()
    private var adapter: NewsAdapter? = null
    lateinit var img_header_utama: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        loadData()


    }
    private fun loadData() {
        ApiClient.client().getDataUtama()
        .enqueue(object : Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                if (response.isSuccessful()) {
                    try {
                        erwinModel = response.body()?.data!!

                        adapter = NewsAdapter(erwinModel){
                            val i = Intent(this@News, DetailNews::class.java)
                            i.putExtra("popular", it)
                            startActivity(i)
                        }
                        val mLayoutManager = LinearLayoutManager(this@News)
                        rc_utama!!.layoutManager = mLayoutManager
                        rc_utama!!.itemAnimator = DefaultItemAnimator()
                        rc_utama!!.adapter = adapter
                    } catch (e: Exception) {

                    }
                }
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {

            }
        })
    }

}