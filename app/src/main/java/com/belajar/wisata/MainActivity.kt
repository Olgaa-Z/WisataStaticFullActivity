package com.belajar.wisata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.belajar.wisata.news.News
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var profil : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        profil = findViewById(R.id.profilwisata)

       profil.setOnClickListener {
            startActivity(Intent(this, ProfilWisata::class.java))
        }

        portalwisata.setOnClickListener {
            val intent = Intent(this, Portalwisata::class.java)
            startActivity(intent)
        }

        lokasiwisata.setOnClickListener {
            val intent = Intent(this, LokasiWisata::class.java)
            startActivity(intent)
        }

        videowisata.setOnClickListener {
            val intent = Intent(this, VideoWisata::class.java)
            startActivity(intent)
        }

        galeriwisata.setOnClickListener {
            val intent = Intent(this, News::class.java)
            startActivity(intent)
        }

        tentang.setOnClickListener {
            val intent = Intent(this, Tentang::class.java)
            startActivity(intent)
        }
    }
}
