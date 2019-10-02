package com.example.workingwithswapilibrary

import retrofit2.converter.moshi.MoshiConverterFactory

object Factory{

    var sharedUrl: String = ""

    val shared: SWApiService by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        return@lazy getNewRouter(sharedUrl)
            .create(SWApiService::class.java)
    }

    private fun getNewRouter(url: String) = retrofit2.Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}