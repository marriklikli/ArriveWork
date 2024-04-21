package com.example.arrivework

data class Music(
    val offers:List<offers>
    )

data class offers(
    val  id: Int,
    val title: String,
    val town: String,
    val price: Price
    )
data class Price(
    val value: Int
    )
