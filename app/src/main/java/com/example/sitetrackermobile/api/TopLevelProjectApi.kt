package com.example.sitetrackermobile.api

import retrofit2.Call
import retrofit2.http.GET

interface TopLevelProjectApi {
    @GET("api/top-level-projects/names")
    fun getAllNames(): Call<List<String>>
}
