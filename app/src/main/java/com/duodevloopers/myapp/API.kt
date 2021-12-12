package com.duodevloopers.myapp

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface API {

    @POST("persons/new")
    suspend fun postAllPersons(@Body persons: Persons): Response<Persons>

}