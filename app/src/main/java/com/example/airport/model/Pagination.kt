package com.example.airport.model

data class Pagination(
    val limit: Int,
    val offset: Int,
    val total: Int
)