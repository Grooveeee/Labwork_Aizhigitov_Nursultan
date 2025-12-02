package com.example.carrentalapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.carrentalapp.model.Car
import com.example.carrentalapp.viewmodel.CarViewModel

@Composable
fun DetailScreen(car: Car?, onBack: () -> Unit, viewModel: CarViewModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        TopAppBar(title = { Text(car?.name ?: "Детали") })
        Spacer(modifier = Modifier.height(8.dp))
        if (car == null) { Text("Автомобиль не найден") } else {
            Text("Марка: ${'$'}{car.brand}")
            Text("Год: ${'$'}{car.year}")
            Text("Цена в день: ${'$'}{car.pricePerDay} тг")
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = { viewModel.book(car.id) }) { Text("Забронировать") }
        }
    }
}
