package com.example.carrentalapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.carrentalapp.model.Car
import com.example.carrentalapp.viewmodel.CarViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: CarViewModel) {
    val cars = viewModel.cars.collectAsState().value
    Scaffold(topBar = { TopAppBar(title = { Text("Каршэринг") }) }) { padding ->
        LazyColumn(Modifier.padding(padding)) {
            items(cars) { car ->
                CarRow(car = car, onOpen = { navController.navigate("detail/${car.id}") }, onBook = { viewModel.book(car.id) })
            }
        }
    }
}

@Composable
fun CarRow(car: Car, onOpen: () -> Unit, onBook: () -> Unit) {
    Row(Modifier.fillMaxWidth().padding(12.dp).clickable { onOpen() }, horizontalArrangement = Arrangement.SpaceBetween) {
        Column { Text(car.name, fontSize = 18.sp); Text(car.brand) }
        Button(onClick = onBook) { Text("Бронировать") }
    }
}
