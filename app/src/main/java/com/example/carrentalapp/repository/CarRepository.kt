package com.example.carrentalapp.repository

import android.content.Context
import com.example.carrentalapp.data.AppDatabase
import com.example.carrentalapp.model.Car
import com.example.carrentalapp.model.Booking

class CarRepository(private val context: Context) {
    private val db = AppDatabase.getInstance(context)
    private val carDao = db.carDao()
    private val bookingDao = db.bookingDao()

    suspend fun populateIfEmpty() {
        val list = carDao.getAll()
        if (list.isEmpty()) {
            val sample = listOf(
                Car(1,"Toyota Camry","Toyota",2020,25000,"","Комфортный седан"),
                Car(2,"BMW M5","BMW",2021,80000,"","Спортивный седан"),
                Car(3,"Hyundai Tucson","Hyundai",2022,30000,"","Кроссовер"),
                Car(4,"Lexus RX","Lexus",2020,55000,"","Премиум кроссовер")
            )
            carDao.insertAll(sample)
        }
    }

    suspend fun getAllCars(): List<Car> = carDao.getAll()
    suspend fun getCarById(id: Int): Car? = carDao.getById(id)
    suspend fun bookCar(carId: Int) { bookingDao.insert(Booking(carId = carId, timestamp = System.currentTimeMillis())) }
    suspend fun getBookings() = bookingDao.getAll()
}
