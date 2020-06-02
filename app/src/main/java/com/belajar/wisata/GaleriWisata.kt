package com.belajar.wisata

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GaleriWisata : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var lm: RecyclerView.LayoutManager
    lateinit var adapter:GaleriAdapter

    val url= arrayOf(
        "https://asset.kompas.com/data/photo/2015/10/30/1150271kebumen780x390.jpg",
        "https://cdn.yukepo.com/content-images/main-images/2017/09/11/main_image_11635.jpg")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galeri_wisata)
        recyclerView=findViewById(R.id.recyclerViewGaleri)
        recyclerView.setHasFixedSize(true)
        lm= GridLayoutManager(this,2)
        recyclerView.layoutManager=lm
        adapter=GaleriAdapter(url,this)
        recyclerView.adapter=adapter
    }


}
