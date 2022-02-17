package com.example.covidpointcomposable.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.covidpointcomposable.R
import com.example.covidpointcomposable.presentation.screens.splash.SplashViewModel
import com.skydoves.landscapist.ImageBySource

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel
) {
    val dataIsReady by viewModel.dataIsReady.observeAsState()



    Box(modifier = Modifier.fillMaxSize()) {
        ImageBySource(
            source = R.drawable.splash_screen_logo,
            modifier = Modifier.wrapContentSize(),
            alignment = Alignment.Center
        )
    }
}