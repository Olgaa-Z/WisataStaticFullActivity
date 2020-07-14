package com.belajar.wisata

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_lokasi_wisata.*

class LokasiWisata : AppCompatActivity(), OnMapReadyCallback, View.OnClickListener{


    lateinit var map: GoogleMap
    lateinit var mp: SupportMapFragment
    lateinit var normal: Button
    lateinit var satellite: Button
    @SuppressLint("MissingPermission")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lokasi_wisata)

        mp= this.supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mp.getMapAsync(this)
        normal=findViewById(R.id.button_Normal)
        satellite=findViewById(R.id.button_Satellite)

        normal.setOnClickListener(this)
        satellite.setOnClickListener(this)
    }


    override fun onMapReady(p0: GoogleMap?) {
        var prambanan : LatLng
        var borobudur : LatLng
        map=p0!!

        prambanan=LatLng(-7.751691,110.491414)
        map.addMarker(MarkerOptions().position(prambanan).title("Prambanan"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(prambanan, 10F))

        borobudur=LatLng(-7.6896953,110.2411883)
        map.addMarker(MarkerOptions().position(borobudur).title("Candi Borobudur"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(borobudur, 10F))


    }

    override fun onClick(v: View?) {

        when(v!!.id){
            R.id.button_Normal->{
                map.mapType= GoogleMap.MAP_TYPE_NORMAL
            }
            R.id.button_Satellite->{
                map.mapType= GoogleMap.MAP_TYPE_HYBRID
            }
        }

    }


}
