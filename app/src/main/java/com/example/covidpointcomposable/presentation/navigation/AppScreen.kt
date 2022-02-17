package com.example.covidpointcomposable.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.covidpointcomposable.presentation.screens.MapScreen
import com.example.covidpointcomposable.presentation.screens.SplashScreen
import com.example.covidpointcomposable.presentation.screens.list.ListScreen

@Composable
fun AppScreen() {
    val navController = rememberNavController()

    NavHost(
        modifier = Modifier.fillMaxSize() ,
        navController = navController,
        startDestination = Destinations.SPLASH_ROUTE
    ){
        composable(Destinations.SPLASH_ROUTE) {
            SplashScreen(navController = navController, viewModel = )
        }

        composable(Destinations.MAP_ROUTE) {
            MapScreen()
        }

        composable(Destinations.LIST_ROUTE) {
            ListScreen(viewModel = )
        }
    }
}