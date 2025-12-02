package com.example.carrentalapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.carrentalapp.model.Booking

@Dao
interface BookingDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(booking: Booking): Long

    @Query("SELECT * FROM bookings ORDER BY timestamp DESC")
    suspend fun getAll(): List<Booking>

    @Query("DELETE FROM bookings WHERE id = :id")
    suspend fun deleteById(id: Int)
}
