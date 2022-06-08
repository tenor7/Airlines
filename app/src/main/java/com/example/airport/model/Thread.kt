package com.example.airport.model

data class Thread(
    val carrier: Carrier,
    val express_type: Any,
    val number: String,
    val short_title: String,
    val thread_method_link: String,
    val title: String,
    val transport_subtype: TransportSubtype,
    val transport_type: String,
    val uid: String,
    val vehicle: Any
)