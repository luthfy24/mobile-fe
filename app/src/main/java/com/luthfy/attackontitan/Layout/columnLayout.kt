package com.luthfy.attackontitan.Layout

import android.service.autofill.OnClickAction
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luthfy.attackontitan.DummyData.ShingekyData
import com.luthfy.attackontitan.DummyData.Titan
import com.luthfy.attackontitan.ui.theme.mainBlue
import com.luthfy.attackontitan.ui.theme.mainGray
import com.luthfy.attackontitan.ui.theme.mainWhite

@Composable
fun columnLayout(
    data : Titan,
    modifier : Modifier = Modifier,
    onClickedItem : (Int) -> Unit
){
    Card(
        modifier = Modifier
            .size(312.dp, 131.dp)
            .padding(10.dp)
            .clickable {
                       onClickedItem(data.id)
            },
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(2.dp, mainBlue),
        colors = CardDefaults.cardColors(containerColor = data.color)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(10.dp)
        ){
            Image(
                painter = painterResource(id = data.pic),
                contentDescription = data.name,
                modifier = Modifier
                    .size(75.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxSize()
            ){
                Text(
                    text = "Nama Titan : ${data.name}",
                    fontSize = 12.sp, color = mainWhite
                )
                Text(text = "Asal Pulau : ${data.tempat}",
                    fontSize = 12.sp, color = mainWhite
                )
                Text(text = "Pengguna : ${data.pemilik}",
                    fontSize = 12.sp, color = mainWhite
                )
            }
        }
    }
}

