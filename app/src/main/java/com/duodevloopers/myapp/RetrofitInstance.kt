package com.duodevloopers.myapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: API by lazy {
        Retrofit.Builder()
            .baseUrl("https://wwww.someurl.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API::class.java)
    }

}