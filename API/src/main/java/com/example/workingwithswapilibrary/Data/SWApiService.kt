package com.example.workingwithswapilibrary.Data

import com.example.workingwithswapilibrary.Data.response.SWResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SWApiService {

    @GET("people")
    suspend fun getAllHeroes(): SWResponse

    @GET("people")
    suspend fun getHeroesByName(
        @Query("search") search: String
    ): SWResponse
}