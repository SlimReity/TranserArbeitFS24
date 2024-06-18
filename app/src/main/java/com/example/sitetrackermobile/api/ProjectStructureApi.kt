package com.example.sitetrackermobile.api

import com.example.sitetrackermobile.model.TblProjectStructure
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProjectStructureApi {
    @GET("api/project-structure")
    fun getAllProjectStructures(): Call<List<TblProjectStructure>>

    @GET("api/project-structure/{id}")
    fun getProjectStructureById(@Path("id") id: Int): Call<TblProjectStructure>

    @GET("api/project-structure/names")
    fun getAllNames(): Call<List<String>>
}
