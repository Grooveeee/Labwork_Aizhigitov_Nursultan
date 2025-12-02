package com.example.carrentalapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable

@Composable
fun CarRentalTheme(content: @Composable () -> Unit) {
    MaterialTheme { Surface { content() } }
}
