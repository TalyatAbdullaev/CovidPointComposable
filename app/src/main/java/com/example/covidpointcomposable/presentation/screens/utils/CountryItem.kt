package com.example.covidpointcomposable.presentation.screens.utils

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.core.content.ContextCompat
import com.example.covidpointcomposable.R
import com.example.covidpointcomposable.presentation.screens.utils.extensions.convertDate
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CountryItem(
    countryName: String,
    imageURL: String,
    confirmedNum: Int,
    confirmedProgress: Float,
    deathsNum: Int,
    deathsProgress: Float,
    recoveredNum: Int,
    recoveredProgress: Float,
    startDate: String,
    endDate: String,
) {
    val context = LocalContext.current

    Column {
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()

        Row {
            Text(text = countryName, Modifier.wrapContentSize())
            ImageOnURL(imageUrl = imageURL)
        }
        StatsBlock(
            label = Stats.CONFIRMED.name,
            number = confirmedNum,
            progress = confirmedProgress
        )
        StatsBlock(label = Stats.DEATHS.name, number = deathsNum, progress = deathsProgress)
        StatsBlock(
            label = Stats.RECOVERED.name,
            number = recoveredNum,
            progress = recoveredProgress
        )
        DateContainer(startDate = startDate.convertDate(), endDate = endDate.convertDate())
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Подробнее")
        }

    }
}

@Composable
private fun ImageOnURL(imageUrl: String) {
    GlideImage(
        imageModel = imageUrl
    )
}

@Composable
private fun StatsBlock(label: String, number: Int, progress: Float) {
    Column {
        Text(text = label)
        Text(text = number.toString())
        LinearProgressIndicator(progress = progress)
    }
}

@Composable
private fun DateContainer(startDate: String, endDate: String) {
    Row {
        Text(text = startDate, textAlign = TextAlign.Start)
        Text(text = endDate, textAlign = TextAlign.End)
    }
}

private enum class Stats(id: Int) {
    CONFIRMED(R.string.confirmed_label),
    DEATHS(R.string.deaths_label),
    RECOVERED(R.string.recovered_label)
}