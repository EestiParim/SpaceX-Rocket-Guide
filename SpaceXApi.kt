package com.example.seep.spacexapp

import retrofit2.Call
import retrofit2.http.GET

interface  SpaceXApi {
    @GET("/v2/rockets")
    fun getTop() : Call<List<RocketDataEntry>>
}