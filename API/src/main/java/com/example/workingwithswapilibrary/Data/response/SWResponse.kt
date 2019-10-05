package com.example.workingwithswapilibrary.Data.response


import com.squareup.moshi.Json

data class SWResponse(
    @field:Json(name = "count")
    val count: Int,
    @field:Json(name = "next")
    val next: Any,
    @field:Json(name = "previous")
    val previous: Any,
    @field:Json(name = "results")
    val results: List<Result>
)