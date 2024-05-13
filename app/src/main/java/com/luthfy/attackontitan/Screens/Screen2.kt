package com.luthfy.attackontitan.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.navigation.NavHostController
import com.luthfy.attackontitan.DummyData.ShingekyData
import com.luthfy.attackontitan.DummyData.Titan
import com.luthfy.attackontitan.Layout.detailLayout
import com.luthfy.attackontitan.Layout.gridLayout
import com.luthfy.attackontitan.Navigasi.Screen
import com.luthfy.attackontitan.ui.theme.mainBlack

@Composable
fun Screen2(
    navController : NavHostController
) {
    val pic = remember { ShingekyData.titan}
    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(mainBlack)
        ){
        items(pic, key = {it.id},
            itemContent = {
                gridLayout(data = it){picId ->
                    navController.navigate(Screen.detailScreen.route + "/$picId")
                }
            }
        )
    }
}