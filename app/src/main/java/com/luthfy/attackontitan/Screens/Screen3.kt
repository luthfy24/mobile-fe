package com.luthfy.attackontitan.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.luthfy.attackontitan.R
import com.luthfy.attackontitan.DummyData.Profile

@Composable
fun AboutContent(
    modifier: Modifier = Modifier
){
    val profile = Profile(
        "Luthfy Fahlevi Amarullah",
        "luthfyfalevi24@gmail.com",
        R.drawable.photo_2

    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        AsyncImage(
            model = profile.image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(
                    bottom = 16.dp,
                )
                .size(200.dp)
                .clip(CircleShape)
        )

        Text(
            text = profile.name,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                )
                .fillMaxWidth()
        )

        Text(
            text = profile.email,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                )
                .fillMaxWidth()
        )

    }
}



