package com.luthfy.attackontitan.Layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luthfy.attackontitan.DummyData.ShingekyData
import com.luthfy.attackontitan.DummyData.Titan
import com.luthfy.attackontitan.ui.theme.mainWhite

@Composable
fun rowLayout(
    data : Titan,
    onItemCLicked : (Int) -> Unit
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                onItemCLicked(data.id)
            }
    ){
        Image(
            painter = painterResource(id = data.pic),
            contentDescription = data.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(percent = 10))
                .border(2.dp, mainWhite)
        )
    }
}