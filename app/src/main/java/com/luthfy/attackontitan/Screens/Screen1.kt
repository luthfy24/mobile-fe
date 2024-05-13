package com.luthfy.attackontitan.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.luthfy.attackontitan.DummyData.ShingekyData
import com.luthfy.attackontitan.Layout.columnLayout
import com.luthfy.attackontitan.Layout.rowLayout
import com.luthfy.attackontitan.Navigasi.Screen
import com.luthfy.attackontitan.ui.theme.mainBlack
import com.luthfy.attackontitan.ui.theme.mainWhite

@Composable
fun Screen1(
    navController : NavHostController
){
    val shingeki  = remember { ShingekyData.titan }
    Box(
      contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(mainBlack)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ){
            Text(
                text = "Lazy Row",
                fontSize = 15.sp,
                color = mainWhite
            )
            Spacer(modifier = Modifier.height(10.dp)
            )
            LazyRow(){
                items(
                    items = shingeki, key = {it.id},
                    itemContent = {
                        rowLayout(data = it){ titanId->
                            navController.navigate(Screen.detailScreen.route + "/$titanId")
                        }
                    }
                )
            }
            Spacer(modifier = Modifier.height(15.dp)
            )
            Text(
                text = "Lazy Column",
                fontSize = 15.sp,
                color = mainWhite
            )
            Spacer(modifier = Modifier.height(10.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
            ){
                LazyColumn(
                ){
                    items(
                        items = shingeki, key = {it.id},
                        itemContent = {
                            columnLayout(data = it){titanId ->
                                navController.navigate(Screen.detailScreen.route + "/$titanId")
                            }
                        }
                    )
                }
            }
        }
    }
}