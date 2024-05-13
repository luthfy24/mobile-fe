package com.luthfy.attackontitan.Layout

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luthfy.attackontitan.DummyData.ShingekyData
import com.luthfy.attackontitan.DummyData.ShingekyData.titan
import com.luthfy.attackontitan.DummyData.Titan
import com.luthfy.attackontitan.ui.theme.mainBlack
import com.luthfy.attackontitan.ui.theme.mainWhite

@Composable
fun detailLayout(
    newTitanList : List<Titan>
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(mainBlack)
    ){
        newTitanList.forEach {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, end = 20.dp)
            ) {
                Box(
                    contentAlignment = Alignment.BottomCenter,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(
                            it.color,
                            RoundedCornerShape(bottomEnd = 100.dp, bottomStart = 100.dp)
                        )
                ) {
                    Image(
                        painter = painterResource(id = it.pic),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(20.dp)
                            .size(150.dp)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp)
                )
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                ){
                    Text(
                        text = it.name,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = mainWhite
                    )
                    Spacer(modifier = Modifier.height(15.dp)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Text(
                                text = "Pengguna",
                                fontSize = 20.sp,
                                color = mainWhite
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = it.pemilik,
                                fontSize = 20.sp,
                                color = mainWhite
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Text(
                                text = "Asal Pulau",
                                fontSize = 20.sp,
                                color = mainWhite
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = it.tempat,
                                fontSize = 20.sp,
                                color = mainWhite
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp)
                    )
                    Text(
                        text = it.desc,
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = mainWhite
                    )
                }
            }
        }
    }
}

