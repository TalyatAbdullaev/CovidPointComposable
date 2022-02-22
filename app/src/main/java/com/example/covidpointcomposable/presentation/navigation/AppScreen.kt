package com.example.covidpointcomposable.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.covidpointcomposable.di.App
import com.example.covidpointcomposable.presentation.screens.map.MapScreen
import com.example.covidpointcomposable.presentation.screens.splash.SplashScreen
import com.example.covidpointcomposable.presentation.screens.list.ListScreen
import com.example.covidpointcomposable.presentation.screens.list.ListViewModel
import com.example.covidpointcomposable.presentation.screens.map.MapViewModel
import com.example.covidpointcomposable.presentation.screens.splash.SplashViewModel
import com.example.covidpointcomposable.presentation.screens.utils.viewmodel.daggerViewModel

@Composable
fun AppScreen() {
    val navController = rememberNavController()

    NavHost (
        modifier = Modifier.fillMaxSize() ,
        navController = navController,
        startDestination = Destinations.SPLASH_ROUTE
    ){
        composable(Destinations.SPLASH_ROUTE) {
            val component = App.graph.splashScreenComponent.build()
            val viewModel: SplashViewModel = daggerViewModel {
                component.getViewModel()
            }
            SplashScreen (navController = navController, viewModel = viewModel)
        }

        composable(Destinations.MAP_ROUTE) {
            val component = App.graph.mapScreenComponent.build()
            val viewModel: MapViewModel = daggerViewModel {
                component.getViewModel()
            }
            MapScreen(viewModel = viewModel)
        }

        composable(Destinations.LIST_ROUTE) {
            val component = App.graph.listScreenComponent.build()
            val viewModel: ListViewModel = daggerViewModel {
                component.getViewModel()
            }
            ListScreen(viewModel = viewModel)
        }
    }
}