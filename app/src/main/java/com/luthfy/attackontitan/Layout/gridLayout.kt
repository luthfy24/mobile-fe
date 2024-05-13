package com.luthfy.attackontitan.Layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.luthfy.attackontitan.DummyData.Titan

@Composable
fun gridLayout(
    data : Titan,
    onItemClicked : (Int) -> Unit

){
        Image(
            painter = painterResource(id = data.pic),
            contentDescription = data.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clickable{
                    onItemClicked(data.id)
                }
        )
}