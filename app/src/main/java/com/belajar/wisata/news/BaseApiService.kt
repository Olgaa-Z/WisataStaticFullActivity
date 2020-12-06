package com.belajar.wisata.news

import retrofit2.Call
import retrofit2.http.GET

public interface BaseApiService {

    @GET("index.php/json/berita_utama")
    fun getDataUtama(): Call<Response>

}