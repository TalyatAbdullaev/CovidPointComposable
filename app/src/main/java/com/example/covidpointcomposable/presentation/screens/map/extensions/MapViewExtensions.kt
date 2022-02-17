package com.example.covidpointcomposable.presentation.screens.map.extensions

import com.yandex.mapkit.Animation
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView

fun MapView.moveCameraToPoint(point: Point, zoom: Float) {
    map.move(
        CameraPosition(point, zoom, 0.0f, 0.0f),
        Animation(Animation.Type.SMOOTH, 0.5F),
        null
    )
}