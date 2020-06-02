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

class LokasiWisata : AppCompatActivity(), OnMapReadyCallback, View.OnClickListener, GoogleMap.OnMyLocationButtonClickListener,
    GoogleMap.OnMyLocationClickListener{


    lateinit var pantai_menganti: LatLng
    lateinit var tugu_lawet:LatLng
    lateinit var pentulu_indah:LatLng
    lateinit var goa_jatijajar:LatLng
    lateinit var goa_barat:LatLng
    lateinit var pantai_logending:LatLng
    lateinit var benteng_gombong:LatLng
    lateinit var pantai_suwuk:LatLng
    lateinit var sempor:LatLng
    lateinit var jembangan:LatLng
    lateinit var curug:LatLng

    lateinit var map: GoogleMap
    lateinit var mp: SupportMapFragment
    lateinit var normal: Button
    lateinit var satellite: Button
    @SuppressLint("MissingPermission")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lokasi_wisata)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)

//        mp=findViewById(R.id.mapFragment)
//        mp=childFragmentManager.findFragmentById(R.id.mapFragment)as SupportMapFragment
//        mp=findViewById(R.id.mapFragment)as SupportMapFragment

//        this.supportFragmentManager.findFragmentById(R.id.mapFragment)
//        (mapFragment as SupportFragment)?.getMapAsync(this)
//        mp.getMapAsync(this)
//        normal=findViewById(R.id.normal)
//        satelit=findViewById(R.id.satelit)
//        hybrid=findViewById(R.id.hybrid)
//        terrain=findViewById(R.id.terrain)
//
//        normal.setOnClickListener(this)
//        satelit.setOnClickListener(this)
//        hybrid.setOnClickListener(this)
//        terrain.setOnClickListener(this)

        this.supportFragmentManager.findFragmentById(R.id.mapFragment)
        mp.getMapAsync(this)
        normal=findViewById(R.id.button_Normal)
        satellite=findViewById(R.id.button_Satellite)

        normal.setOnClickListener(this)
        satellite.setOnClickListener(this)
    }

    override fun onMapReady(p0: GoogleMap?) {
        map=p0!!
        val permission = this.let {
            ContextCompat.checkSelfPermission(
                it,
                Manifest.permission.ACCESS_FINE_LOCATION)
        }

        if (permission == PackageManager.PERMISSION_GRANTED) {
            map.setMyLocationEnabled(true);
            map.setOnMyLocationButtonClickListener(this);
            map.setOnMyLocationClickListener(this);
            map.uiSettings.setZoomControlsEnabled(true);
        }
//        curug= LatLng(-7.559110, 109.726400)
//        map.addMarker(MarkerOptions().position(curug).title("Curug Sindaro"))
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(curug,10F))
//
//        jembangan= LatLng(-7.654608, 109.770374)
//        map.addMarker(MarkerOptions().position(jembangan).title("Jembangan"))
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(jembangan,10F))
//
//        sempor= LatLng(-7.560362, 109.485089)
//        map.addMarker(MarkerOptions().position(sempor).title("Waduk Sempor"))
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sempor,10F))
//
//        pantai_menganti= LatLng(-7.770181, 109.413023)
//        map.addMarker(MarkerOptions().position(pantai_menganti).title("Pantai Menganti"))
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pantai_menganti,10F))
//
//        tugu_lawet= LatLng(-7.670917, 109.660838)
//        map.addMarker(MarkerOptions().position(tugu_lawet).title("Tugu Lawet"))
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(tugu_lawet,10F))
//
//        pentulu_indah= LatLng(-7.536018, 109.680097)
//        map.addMarker(MarkerOptions().position(pentulu_indah).title("Pentulu Indah"))
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pentulu_indah,10F))
//
//        goa_jatijajar= LatLng(-7.668303, 109.426248)
//        map.addMarker(MarkerOptions().position(goa_jatijajar).title("Goa Jatijajar"))
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(goa_jatijajar,10F))
//
//        goa_barat= LatLng(-7.665484, 109.435925)
//        map.addMarker(MarkerOptions().position(goa_barat).title("Goa Barat"))
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(goa_barat,10F))
//
//        pantai_logending= LatLng(-7.725484, 109.394316)
//        map.addMarker(MarkerOptions().position(pantai_logending).title("Pantai Logending"))
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pantai_logending,10F))
//
//        benteng_gombong= LatLng(-7.599416, 109.517579)
//        map.addMarker(MarkerOptions().position(benteng_gombong).title("Benteng Van Der Wijck"))
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(benteng_gombong,10F))
//
//        pantai_suwuk= LatLng(-7.758646, 109.470034)
//        map.addMarker(MarkerOptions().position(pantai_suwuk).title("Pantai Suwuk"))
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pantai_suwuk,10F))


        val builder = LatLngBounds.Builder()
        builder.include(pantai_menganti)
        builder.include(tugu_lawet)
        builder.include(benteng_gombong)
        builder.include(pantai_suwuk)
        builder.include(pantai_logending)
        builder.include(goa_barat)
        builder.include(goa_jatijajar)
        builder.include(sempor)
        builder.include(jembangan)
        builder.include(curug)
        builder.include(pentulu_indah)
        val bounds = builder.build()
        map.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 20))

//        map.setOnMarkerClickListener(this)
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


    override fun onMyLocationClick(p0: Location) {

    }

    override fun onMyLocationButtonClick(): Boolean {
        return false
    }


}
