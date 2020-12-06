package com.belajar.wisata.news

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object ApiClient {

    const val BASE_URL = "http://server4111.com/webberita/"
    fun client(): BaseApiService {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(BaseApiService::class.java)
    }

    val okHttp: OkHttpClient
        get() {
            val logging =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            return OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
        }
}
