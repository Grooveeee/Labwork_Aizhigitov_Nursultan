package com.example.carrentalapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.carrentalapp.model.Car

@Dao
interface CarDao {
    @Query("SELECT * FROM cars")
    suspend fun getAll(): List<Car>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cars: List<Car>)

    @Query("SELECT * FROM cars WHERE id = :id LIMIT 1")
    suspend fun getById(id: Int): Car?
}
