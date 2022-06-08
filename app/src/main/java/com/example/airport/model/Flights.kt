package com.example.airport.model

data class Flights(
    val interval_segments: List<Any>,
    val pagination: Pagination,
    val search: Search,
    val segments: List<Segment>
)

fun Flights.fromFlightsToListOfFlight():MutableList<Flight>{
    val flights:MutableList<Flight> = mutableListOf()
    segments.forEach {
        val fromTime = it.departure
        val from = search.from.title
        val to = search.to.title
        val company = it.thread.carrier.title
        val number = it.thread.number
        val airport = it.from.title
        val logo = it.thread.carrier.logo
        if (logo !== null) {
            flights.add(Flight(to, from, fromTime, company, logo, airport, number))
        }
        if (number !== number) {
            flights.add(Flight(to, from, fromTime, company, logo, airport, number))
        }
    }
    return flights
}
