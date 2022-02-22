package com.example.covidpointcomposable.presentation.screens.splash

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.SaveableStateHolder
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.covidpointcomposable.R
import com.example.covidpointcomposable.presentation.navigation.Destinations
import com.example.covidpointcomposable.presentation.screens.splash.SplashViewModel
import com.skydoves.landscapist.ImageBySource
import javax.inject.Inject


@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel
) {
//    val dataIsReady by viewModel.dataIsReady.collectAsState()
//    if(dataIsReady) {
//        navController.navigate(Destinations.MAP_ROUTE)
//        Log.d("TAG", "navigate")
//        return
//    }
    
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_screen_logo),
            contentDescription = "Логотип",
            modifier = Modifier
                .width(Dp(195F))
                .height(Dp(97F)),
        )
        
        Button(onClick = { navController.navigate(Destinations.LIST_ROUTE) }) {
            Text(text = "Button")
        }
    }
}