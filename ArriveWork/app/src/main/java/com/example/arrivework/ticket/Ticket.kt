package com.example.arrivework

data class Ticket(
    val tickets: List<Tickets>
)
data class Tickets(
    val id: Int,
    val badge: String,
    val price: Price3,
    val provider_name: String,
    val company: String,
    val departure: Departure,
    val arrival: Arrival,
    val has_transfer: Boolean,
    val has_visa_transfer: Boolean,
    val luggage: Luggage,
    val hand_luggage: HandLuggage,
    val is_returnable: Boolean,
    val is_exchangable: Boolean
)
data class Price3(
    val value: Int
)
data class Departure(
    val town: String,
    val date: String,
    val airport: String
)
data class Arrival(
    val town: String,
    val date: String,
    val airport: String
)
data class Luggage(
    val has_luggage: Boolean,
    val price: Price4
)
data class Price4(
    val value: Int
)
data class HandLuggage(
    val has_hand_luggage: Boolean,
    val size: String
)