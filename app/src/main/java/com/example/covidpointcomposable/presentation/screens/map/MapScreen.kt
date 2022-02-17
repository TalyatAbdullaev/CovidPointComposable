package com.example.covidpointcomposable.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.example.covidpointcomposable.presentation.screens.map.extensions.moveCameraToPoint
import com.example.covidpointcomposable.presentation.screens.map.utils.MapViewUtils
import com.yandex.mapkit.mapview.MapView

@Composable
fun MapScreen() {
    val context = LocalContext.current
    val mapView = remember { MapView(context) }

    AndroidView(modifier = Modifier.fillMaxSize(), factory = { mapView })
    setupMapView(mapView = mapView)
}

private fun setupMapView(mapView: MapView) {
    mapView.map.isRotateGesturesEnabled = false
    mapView.moveCameraToPoint(
        point = MapViewUtils.DEFAULT_POINT,
        zoom = MapViewUtils.DEFAULT_CAMERA_ZOOM
    )
}