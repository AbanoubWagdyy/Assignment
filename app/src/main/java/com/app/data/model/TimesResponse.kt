package com.app.data.model

data class TimesResponse(
    val copyright: String,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)