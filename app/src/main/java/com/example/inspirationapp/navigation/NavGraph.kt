package com.example.inspirationapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.inspirationapp.ui.QuoteScreen
import com.example.inspirationapp.ui.WelcomeScreen

object Destinations {
    const val Welcome = "welcome"
    const val Quote   = "quote"
}

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController  = navController,
        startDestination = Destinations.Welcome
    ) {
        composable(Destinations.Welcome) {
            WelcomeScreen(
                onStartClick = {
                    navController.navigate(Destinations.Quote)
                }
            )
        }

        composable(Destinations.Quote) {
            QuoteScreen(
                onBackClick = {
                    navController.popBackStack()  // retourne à l'accueil
                }
            )
        }
    }
}
