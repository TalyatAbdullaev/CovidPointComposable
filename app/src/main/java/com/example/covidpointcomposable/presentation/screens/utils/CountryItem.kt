package com.example.covidpointcomposable.presentation.screens.utils

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.covidpointcomposable.R
import com.example.covidpointcomposable.data.pojo.Country
import com.example.covidpointcomposable.presentation.screens.utils.extensions.convertDate
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.rememberDrawablePainter
import java.io.FileDescriptor

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

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp)

    ) {
        Row(
            modifier = Modifier.fillMaxWidth().wrapContentHeight()
        ) {
            Text(
                text = countryName,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.wrapContentSize()
            )
            CountryFlag(
                imageUrl = imageURL,
                modifier = Modifier.wrapContentSize(),
                contentDescription = "Флаг",
                alignment = Alignment.CenterEnd
            )
        }
        StatsBlock(label = Stats.CONFIRMED.name, number = confirmedNum, progress = confirmedProgress)
        StatsBlock(label = Stats.DEATHS.name, number = deathsNum, progress = deathsProgress)
        StatsBlock(label = Stats.RECOVERED.name, number = recoveredNum, progress = recoveredProgress)
        DateContainer(startDate = startDate.convertDate(), endDate = endDate.convertDate())
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Подробнее")
        }

    }
}

@Composable
private fun CountryFlag(
    imageUrl: String,
    modifier: Modifier,
    contentDescription: String,
    alignment: Alignment
) {
    GlideImage(
        imageModel = imageUrl,
        contentScale = ContentScale.Crop,
        success = {
            Image(
                painter = rememberDrawablePainter(drawable = it.drawable),
                contentDescription = contentDescription,
                modifier = Modifier.align(alignment = alignment)
            )
        },
        failure = {
            Log.d("TAG", it.toString())
        },
        loading = {

        }
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
    CONFIRMED(R.string.label_confirmed),
    DEATHS(R.string.label_deaths),
    RECOVERED(R.string.label_recovered)
}