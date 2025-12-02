package com.example.carrentalapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cars")
data class Car(
    @PrimaryKey val id: Int,
    val name: String,
    val brand: String,
    val year: Int,
    val pricePerDay: Int,
    val imageUrl: String = "",
    val description: String = ""
)
