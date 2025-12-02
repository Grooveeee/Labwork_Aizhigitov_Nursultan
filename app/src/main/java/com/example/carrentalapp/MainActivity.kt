package com.example.carrentalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.carrentalapp.ui.theme.CarRentalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarRentalTheme {
                Surface {
                    val navController = rememberNavController()
                    val viewModel: CarViewModel = viewModel(factory = CarViewModelFactory(LocalContext.current))

                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") { HomeScreen(navController = navController, viewModel = viewModel) }
                        composable("detail/{carId}") { backStackEntry ->
                            val id = backStackEntry.arguments?.getString("carId")?.toIntOrNull()
                            val car = viewModel.getCarById(id)
                            DetailScreen(car = car, onBack = { navController.popBackStack() }, viewModel = viewModel)
                        }
                        composable("favorites") { FavoritesScreen(viewModel = viewModel, onOpenDetail = { id -> navController.navigate("detail/" + id) }) }
                        composable("history") { HistoryScreen(viewModel = viewModel) }
                    }
                }
            }
        }
    }
}
