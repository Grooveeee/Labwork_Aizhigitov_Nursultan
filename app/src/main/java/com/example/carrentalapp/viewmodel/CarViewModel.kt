package com.example.carrentalapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carrentalapp.model.Car
import com.example.carrentalapp.repository.CarRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CarViewModel(private val context: Context) : ViewModel() {
    private val repo = CarRepository(context)

    private val _cars = MutableStateFlow<List<Car>>(emptyList())
    val cars: StateFlow<List<Car>> = _cars

    private val _bookings = MutableStateFlow(0)
    val bookings = _bookings

    init {
        viewModelScope.launch {
            repo.populateIfEmpty()
            _cars.value = repo.getAllCars()
            _bookings.value = repo.getBookings().size
        }
    }

    fun getCarById(id: Int?) = _cars.value.firstOrNull { it.id == id }

    fun book(carId: Int) {
        viewModelScope.launch {
            repo.bookCar(carId)
            _bookings.value = repo.getBookings().size
            _cars.value = repo.getAllCars()
        }
    }
}
