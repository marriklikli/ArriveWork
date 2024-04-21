package com.example.arrivework

data class Country(
    val tickets_offers: List<ticketsoffers>
)
data class ticketsoffers(
    val id: Int,
    val title: String,
    val time_range: String,
    val price: Price2
)
data class Price2(
    val value: Int
)
