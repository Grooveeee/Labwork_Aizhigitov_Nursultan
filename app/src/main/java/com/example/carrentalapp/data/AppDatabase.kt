package com.example.carrentalapp.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.example.carrentalapp.model.Car
import com.example.carrentalapp.model.Booking

@Database(entities = [Car::class, Booking::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun carDao(): CarDao
    abstract fun bookingDao(): BookingDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase = INSTANCE ?: synchronized(this) {
            val inst = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "car_rental_db").build()
            INSTANCE = inst
            inst
        }
    }
}
