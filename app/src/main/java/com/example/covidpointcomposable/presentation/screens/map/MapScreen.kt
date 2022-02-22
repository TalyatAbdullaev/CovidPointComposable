package com.example.covidpointcomposable.presentation.screens.map

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.viewinterop.AndroidView
import com.example.covidpointcomposable.R
import com.example.covidpointcomposable.data.database.countries.CountryEntity
import com.example.covidpointcomposable.presentation.screens.map.extensions.moveCameraToPoint
import com.example.covidpointcomposable.presentation.screens.map.utils.MapViewUtils
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.*
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider
import com.yandex.runtime.ui_view.ViewProvider

@Composable
fun MapScreen(viewModel: MapViewModel) {
    val context = LocalContext.current
    val mapView = remember { MapView(context) }

    val countries: List<CountryEntity> by viewModel.countries.observeAsState(listOf())

    fun setupMapView() {
        mapView.map.isRotateGesturesEnabled = false
        mapView.moveCameraToPoint(
            point = MapViewUtils.DEFAULT_POINT,
            zoom = MapViewUtils.DEFAULT_CAMERA_ZOOM
        )
    }

    @Composable
    fun showCountries(countries: List<CountryEntity>) {
        val pointCollection = mapView.map.mapObjects.addClusterizedPlacemarkCollection { cluster ->
            cluster.appearance.setIcon(ImageProvider.fromResource(context, R.drawable.ic_mark))
            cluster.addClusterTapListener {
                Log.d("TAG", "cluster tap")
                mapView.moveCameraToPoint(it.appearance.geometry, mapView.map.cameraPosition.zoom + 1)
                true
            }
        }

        countries.forEach {
            val point = Point(it.latitude, it.longitude)
            val data = UserData(mapOf(MapViewUtils.ID_KEY to it.id.toString()))

            val placemark = pointCollection.addPlacemark(point)
            val placemarkView = MarkerItem(text = it.confirmed.toString())
//            placemark.setView(ViewProvider(placemarkView))
//            placemark.userData = data
//            placemark.addTapListener(MapObjectTapListener())
        }
        pointCollection.clusterPlacemarks(60.0, 15)
    }

    AndroidView(modifier = Modifier.fillMaxSize(), factory = { mapView })
    setupMapView()
//    showCountries(countries)



    LaunchedEffect(Unit) {
        mapView.onStart()
        MapKitFactory.getInstance().onStart()
    }


    DisposableEffect(Unit) {
        onDispose {
            mapView.onStop()
            MapKitFactory.getInstance().onStop()
        }
    }
}

@Composable
fun MarkerItem(text: String) {
    Box(modifier = Modifier.wrapContentSize()) {
        Image(painter = painterResource(id = R.drawable.ic_mark), contentDescription = "Маркер")
        Text(text = text)
    }
}

//override fun onMapObjectTap(mapObject: MapObject, point: Point): Boolean {
//    Log.d("TAG", "tap")
//    presenter.onPlacemarkTap(mapObject)
//    return true
//}