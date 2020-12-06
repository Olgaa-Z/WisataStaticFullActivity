package com.belajar.wisata.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.belajar.wisata.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_news.*

class DetailNews : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)
        val itn = intent.getSerializableExtra("popular") as? DataItem

        tv_detail_utama_judul.text = itn?.judul
        tv_detail_utama_isi.text = itn?.isiBerita
        tv_detail_utama_tanggal.text = itn?.tglBerita
        Glide.with(this).load("http://server4111.com/webberita/"+ "assets/gambar/${itn?.gambar}")
            .into(iv_detail_utama_gambar)

//        Glide.with(this).load(ApiClient.BASE_URL+"assets/gambar/${itn?.gambar}").into(iv_detail_utama_gambar)

    }
}