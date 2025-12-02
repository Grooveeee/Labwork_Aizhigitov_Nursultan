package com.example.carrentalapp.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.carrentalapp.viewmodel.CarViewModel

@Composable
fun FavoritesScreen(viewModel: CarViewModel, onOpenDetail: (Int) -> Unit) {
    // For simplicity favorites reused bookings count; stub implementation
    Text("Избранное / Бронирования: ${'$'}{viewModel.bookings}")
}
