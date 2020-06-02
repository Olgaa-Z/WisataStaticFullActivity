package com.belajar.wisata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener

class ProfilWisata : AppCompatActivity() {

    lateinit var carouselView: CarouselView
    val sampleImages= intArrayOf(R.drawable.pantaibatubiru,R.drawable.nihiwaturesort,R.drawable.pantailasiana,R.drawable.danaukelimutu,R.drawable.goabatucermin,
        R.drawable.pulaupadar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil_wisata)
        val view: View
        carouselView=findViewById(R.id.carouselView)
        carouselView.setPageCount(6)
        carouselView.setImageListener(imageListener)
    }

    var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            Glide.with(this@ProfilWisata).load(sampleImages[position]).into(imageView)
        }
    }
}
